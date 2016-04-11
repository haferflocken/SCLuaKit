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
paramList : idList (',' '...')? | '...' ;
varList : var (',' var)* ;
expressionList : expression (',' expression)* ;

chunk : (statement ';'?)* ;

// TODO build a more meaningful AST
statement
    : varList '=' expressionList // Assignment (or declaration of global variables)
    | prefixExp args // Function call
    | prefixExp ':' ID args // Method call
    | 'do' chunk 'end' // Explicit block
    | 'while' expression 'do' chunk 'end' // While loop
    | 'repeat' chunk 'until' expression // Repeat-until loop (the condition may use local variables in the loop)
    | 'if' expression 'then' chunk ('elseif' expression 'then' chunk)* ('else' chunk)? 'end' // If/then/elseif/else
    | 'return' expressionList? // Return
    | 'break' // Break
    | 'continue' // Continue
    | 'for' ID '=' expression ',' expression (',' expression)? 'do' chunk 'end' // Numeric for loop
    | 'for' ID (',' ID)? 'in' expression 'do' chunk 'end' // Foreach loop
    | 'function' funcName funcBody // Function declaration
    | 'local' 'function' ID funcBody // Local function declaration
    | 'local' idList ('=' expressionList)? ; // Local variable declaration and initialization

funcName
    : ID
    | ID '.' ID
    | ID ':' ID ;

// Logical operator precedence.
expression : orExpression ;
orExpression : andExpression ('or' andExpression)* ;
andExpression : bitwiseOrExpression ('and' bitwiseOrExpression)* ;

// Bitwise operator precedence.
bitwiseOrExpression : bitwiseAndExpression ('|' bitwiseAndExpression)* ;
bitwiseAndExpression : equalityExpression ('&' equalityExpression)* ;

// Equality and relational operator precedence.
equalityExpression : relationalExpression (('=='|'~='|'!=') relationalExpression)* ;
relationalExpression : concatExpression (('<'|'>'|'<='|'>=') concatExpression)* ;

// Concatenation is between inequality and addition in precedence.
concatExpression : addExpression ('..' addExpression)* ;

// Arithmetic operator precedence.
addExpression : multExpression (('+'|'-') multExpression)* ;
multExpression : negationExpression (('*'|'/'|'%') negationExpression)* ;
negationExpression : ('-'|'not') negationExpression | powerExpression ; // 'not' is not arithmetic but belongs here in precedence
powerExpression : primaryExpression ('^' primaryExpression)* ;

primaryExpression
    : prefixExp
    | literal // Literal
    | functionDecl // Function declaration
    | tableConstructor // Table constructor
    | upValue // Upvalue
    | '...' ; // Varargs

prefixExp
    : prefixExp args // Function call
    | prefixExp ':' ID args // Method call
    | prefixExp '[' expression ']' // Table access
    | prefixExp '.' ID // Table access sugar
    | '(' expression ')' // Parenthetical expression
    | ID ; // Identifier

args
    : '(' expressionList? ')' // Standard function argument syntax. Ex: foo(a, b, c)
    | tableConstructor // Table arg for unary function syntax. Ex: foo {a, b, c}
    | STRING_LITERAL ; // String literal arg for unary function syntax. Ex: foo 'bar'

functionDecl : 'function' funcBody ;

funcBody : '(' paramList? ')' chunk 'end' ;

tableConstructor : '{' ((fField | expression) ((','|';') (fField | expression))* ','?)? '}' ;
fField : '[' expression ']' '=' expression | ID '=' expression ;

upValue : '%' ID ;

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
