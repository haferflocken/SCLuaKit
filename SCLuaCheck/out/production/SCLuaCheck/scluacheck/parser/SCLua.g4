grammar SCLua;

// Supreme Commander uses Lua 5 with a few modifications. It is built of of LuaPlus.
//   Line comments can begin with #
//   Table constructors do not mandate separating indexed and named fields with a semicolon
//   != is a new relational operator (behaves identically to ~=)
//   continue is a new loop control keyword which acts like continue in other languages
//   | is a new binary operator which performs a bitwise or
//   & is a new binary operator which performs a bitwise and

// Visible C functions:
//   BuilderGroup(groupTable)
//   Builder(builderTable)

// Parser rules start with a lowercase letter.

start : chunk EOF ;

idList  : ID (',' ID)* ;
paramList : idList (',' varArgsExpression)? | varArgsExpression ;
varList : var (',' var)* ;
expressionList : expression (',' expression)* ;

// START OF MAIN AST NODES
// vvvvvvvvvvvvvvvvvvvvvvv
chunk : (statement ';'?)* ;

statement
    : assignmentStatement
    | functionCallStatement
    | methodCallStatement
    | explicitBlockStatement
    | whileStatement
    | repeatUntilStatement
    | ifStatement
    | returnStatement
    | breakStatement
    | continueStatement
    | forNumericStatement
    | forEachStatement
    | functionDeclarationStatement
    | localFunctionDeclarationStatement
    | localVariableDeclarationStatement ;

assignmentStatement : varList '=' expressionList ; // Also declares global variables.
functionCallStatement : prefixExp args ;
methodCallStatement : prefixExp ':' ID args ;
explicitBlockStatement : 'do' chunk 'end' ;
whileStatement : 'while' expression 'do' chunk 'end' ;
repeatUntilStatement : 'repeat' chunk 'until' expression ;
ifStatement : ifPartIf ifPartElseif* ifPartElse? 'end' ;
returnStatement : 'return' expressionList? ;
breakStatement : 'break' ;
continueStatement : 'continue' ;
forNumericStatement : 'for' ID '=' expression ',' expression (',' expression)? 'do' chunk 'end';
forEachStatement : 'for' ID (',' ID)? 'in' expression 'do' chunk 'end' ;
functionDeclarationStatement : 'function' funcName funcBody ;
localFunctionDeclarationStatement : 'local' 'function' ID funcBody ;
localVariableDeclarationStatement : 'local' idList ('=' expressionList)? ;

// Logical operator precedence.
expression : orExpression ;
orExpression : andExpression ('or' andExpression)* ;
andExpression : bitwiseOrExpression ('and' bitwiseOrExpression)* ;

// Bitwise operator precedence.
bitwiseOrExpression : bitwiseAndExpression ('|' bitwiseAndExpression)* ;
bitwiseAndExpression : equalityExpression ('&' equalityExpression)* ;

// Equality and relational operator precedence.
equalityExpression : relationalExpression (equalityOp relationalExpression)* ;
relationalExpression : concatExpression (relationalOp concatExpression)* ;

// Concatenation is between inequality and addition in precedence.
concatExpression : addExpression ('..' addExpression)* ;

// Arithmetic operator precedence.
addExpression : multExpression (addOp multExpression)* ;
multExpression : negationExpression (multOp negationExpression)* ;
negationExpression : negationOp negationExpression | powerExpression ; // 'not' is not arithmetic but belongs here in precedence
powerExpression : primaryExpression ('^' primaryExpression)* ;

primaryExpression
    : prefixExp
    | literal // Literal
    | functionDeclExpression // Function declaration
    | tableConstructor // Table constructor
    | upValue // Upvalue
    | varArgsExpression ; // Varargs

prefixExp
    : prefixExp (prefixPartFunctionCall | prefixPartMethodCall | prefixPartTableAccess | prefixPartDotAccess)
    | parentheticalExpression
    | ID ;

parentheticalExpression : '(' expression ')';

functionDeclExpression : 'function' funcBody ;

tableConstructor : '{' (tableEntry ((','|';') tableEntry)* ','?)? '}' ;

upValue : '%' ID ;

varArgsExpression : '...' ;
// ^^^^^^^^^^^^^^^^^^^^^
// END OF MAIN AST NODES

ifPartIf : 'if' expression 'then' chunk ;
ifPartElseif : 'elseif' expression 'then' chunk ;
ifPartElse : 'else' chunk ;

funcName
    : ID
    | ID '.' ID
    | methodName ;

methodName : ID ':' ID ;

args
    : '(' expressionList? ')' // Standard function argument syntax. Ex: foo(a, b, c)
    | tableConstructor // Table arg for unary function syntax. Ex: foo {a, b, c}
    | STRING_LITERAL ; // String literal arg for unary function syntax. Ex: foo 'bar'

funcBody : '(' paramList? ')' chunk 'end' ;

equalityOp : '==' | '~=' | '!=' ;
relationalOp : '<' | '>' | '<=' | '>=' ;
addOp : '+' | '-' ;
multOp : '*' | '/' | '%' ;
negationOp : '-' | 'not' ;

tableEntry : '[' expression ']' '=' expression | ID '=' expression | expression;

var
    : prefixExp '[' expression ']'
    | prefixExp '.' ID
    | ID ;

literal
    : booleanLiteral
    | numericLiteral
    | STRING_LITERAL
    | 'nil' ;

booleanLiteral : 'true' | 'false' ;

numericLiteral
    : HEX_LITERAL
    | INT_LITERAL
    | FLOAT_LITERAL ;

prefixPartFunctionCall : args ;
prefixPartMethodCall : ':' ID args ;
prefixPartTableAccess : '[' expression ']';
prefixPartDotAccess : '.' ID ;

// Lexer rules start with an uppercase letter.

HEX_LITERAL : '0' ('x'|'X') [0-9A-Fa-f]+ ;
INT_LITERAL : BASIC_INT EXPONENT? ;
FLOAT_LITERAL : BASIC_INT? '.' BASIC_INT EXPONENT? ;

fragment BASIC_INT : [0-9]+ ;
fragment EXPONENT : ('e'|'E') ('+'|'-')? BASIC_INT ;

STRING_LITERAL
    : '"' ( ESCAPE_LITERAL | ~('\\' | '"') )* '"'
    | '\'' ( ESCAPE_LITERAL | ~('\\' | '\'') )* '\''
    | '[[' ( ~']' | ']' ~']' )* ']]' ; // This only matches [[ ]] long bracket strings.

ESCAPE_LITERAL : '\\a' | '\\b' | '\\f' | '\\n' | '\\r' | '\\t' | '\\v' | '\\\\' | '\\"' | '\\\'' ;

ID : [A-Za-z_][A-Za-z_0-9]* ; // "Names (also called identifiers) in Lua can be any string of letters, digits, and underscores, not beginning with a digit."

fragment NEWLINE : '\r'? '\n' ;
LINE_COMMENT : ('--'|'#') ~[\r\n]* NEWLINE? -> skip ; // Line comments start with -- or #. The NEWLINE is optional to allow the comment to end with the end of the file.
LONG_COMMENT : '--[[' .*? ']]' -> skip ; // Long comments start with --[[ and end with ]]
WS : [ \t\r\n]+ -> skip ;
