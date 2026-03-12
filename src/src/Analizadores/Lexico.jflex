package analizadores;

import java_cup.runtime.Symbol;
import java.util.LinkedList;
import utils.FileUtils;
import Reportes.TablaTokens;
import Reportes.TablaErrores;

%%


%init{
    yyline = 0;
    yycolumn = 0;
%init}

// PROPIEDADES 
%class Lexico
%public
%line
%column
%cup
%unicode
%ignorecase

%{

    public LinkedList<String> listaErrores = new LinkedList<>();

    private void imprimir(String token){
        System.out.println(
            "Token: " + token +
            " | Lexema: '" + yytext() + "'" +
            " | Linea: " + (yyline + 1) +
            " | Columna: " + (yycolumn + 1)
        );
    }

%}


// EXPRESIONES REGULARES 

D       = [0-9]+
DEC     = [0-9]+"."[0-9]+
ID      = [a-zA-Z][a-zA-Z0-9_]*
STRING  = \"([^\"\\]|\\.)*\"

comentario1 = "##".*
comentario2 = "#*"([^#]|\n)*"#*"

%%

///////////// PALABRAS RESERVADAS

"database" {
    TablaTokens.agregar("database", yytext(), yyline, yycolumn);
    return new Symbol(sym.DATABASE, yyline+1, yycolumn+1, yytext());
}

"use" {
    TablaTokens.agregar("use", yytext(), yyline, yycolumn);
    return new Symbol(sym.USE, yyline+1, yycolumn+1, yytext());
}

"table" {
    TablaTokens.agregar("table", yytext(), yyline, yycolumn);
    return new Symbol(sym.TABLE, yyline+1, yycolumn+1, yytext());
}

"read" {
    TablaTokens.agregar("read", yytext(), yyline, yycolumn);
    return new Symbol(sym.READ, yyline+1, yycolumn+1, yytext());
}

"fields" {
    TablaTokens.agregar("fields", yytext(), yyline, yycolumn);
    return new Symbol(sym.FIELDS, yyline+1, yycolumn+1, yytext());
}

"filter" {
    TablaTokens.agregar("filter", yytext(), yyline, yycolumn);
    return new Symbol(sym.FILTER, yyline+1, yycolumn+1, yytext());
}

"add" {
    TablaTokens.agregar("add", yytext(), yyline, yycolumn);
    return new Symbol(sym.ADD, yyline+1, yycolumn+1, yytext());
}

"update" {
    TablaTokens.agregar("update", yytext(), yyline, yycolumn);
    return new Symbol(sym.UPDATE, yyline+1, yycolumn+1, yytext());
}

"clear" {
    TablaTokens.agregar("clear", yytext(), yyline, yycolumn);
    return new Symbol(sym.CLEAR, yyline+1, yycolumn+1, yytext());
}

"export" {
    TablaTokens.agregar("export", yytext(), yyline, yycolumn);
    return new Symbol(sym.EXPORT, yyline+1, yycolumn+1, yytext());
}

"store" {
    TablaTokens.agregar("store", yytext(), yyline, yycolumn);
    return new Symbol(sym.STORE, yyline+1, yycolumn+1, yytext());
}

"at" {
    TablaTokens.agregar("at", yytext(), yyline, yycolumn);
    return new Symbol(sym.AT, yyline+1, yycolumn+1, yytext());
}

"set" {
    TablaTokens.agregar("set", yytext(), yyline, yycolumn);
    return new Symbol(sym.SET, yyline+1, yycolumn+1, yytext());
}

// TIPOS 

"int" {
    TablaTokens.agregar("int", yytext(), yyline, yycolumn);
    return new Symbol(sym.INT, yyline+1, yycolumn+1, yytext());
}

"float" {
    TablaTokens.agregar("float", yytext(), yyline, yycolumn);
    return new Symbol(sym.FLOAT, yyline+1, yycolumn+1, yytext());
}

"bool" {
    TablaTokens.agregar("bool", yytext(), yyline, yycolumn);
    return new Symbol(sym.BOOL, yyline+1, yycolumn+1, yytext());
}

"string" {
    TablaTokens.agregar("string", yytext(), yyline, yycolumn);
    return new Symbol(sym.STRING_TYPE, yyline+1, yycolumn+1, yytext());
}

"array" {
    TablaTokens.agregar("array", yytext(), yyline, yycolumn);
    return new Symbol(sym.ARRAY, yyline+1, yycolumn+1, yytext());
}

"object" {
    TablaTokens.agregar("object", yytext(), yyline, yycolumn);
    return new Symbol(sym.OBJECT, yyline+1, yycolumn+1, yytext());
}

"null" {
    TablaTokens.agregar("null", yytext(), yyline, yycolumn);
    return new Symbol(sym.NULL, yyline+1, yycolumn+1, yytext());
}

// BOOLEANOS 

"true" {
    TablaTokens.agregar("true", yytext(), yyline, yycolumn);
    return new Symbol(sym.TRUE, yyline+1, yycolumn+1, yytext());
}

"false" {
    TablaTokens.agregar("false", yytext(), yyline, yycolumn);
    return new Symbol(sym.FALSE, yyline+1, yycolumn+1, yytext());
}

// OPERADORES RELACIONALES 

"==" {
    TablaTokens.agregar("IGUAL", yytext(), yyline, yycolumn);
    return new Symbol(sym.IGUAL, yyline+1, yycolumn+1, yytext());
}

"!=" {
    TablaTokens.agregar("DIFERENTE", yytext(), yyline, yycolumn);
    return new Symbol(sym.DIFERENTE, yyline+1, yycolumn+1, yytext());
}

">=" {
    TablaTokens.agregar("MAYOIGUAL", yytext(), yyline, yycolumn);
    return new Symbol(sym.MAYORIGUAL, yyline+1, yycolumn+1, yytext());
}

"<=" {
    TablaTokens.agregar("AGREGAR", yytext(), yyline, yycolumn);
    return new Symbol(sym.MENORIGUAL, yyline+1, yycolumn+1, yytext());
}

">" {
    TablaTokens.agregar("MAYOR", yytext(), yyline, yycolumn);
    return new Symbol(sym.MAYOR, yyline+1, yycolumn+1, yytext());
}

"<" {
    TablaTokens.agregar("MENOR", yytext(), yyline, yycolumn);
    return new Symbol(sym.MENOR, yyline+1, yycolumn+1, yytext());
}

// OPERADORES LÓGICOS 

"&&" {
    TablaTokens.agregar("AND", yytext(), yyline, yycolumn);
    return new Symbol(sym.AND, yyline+1, yycolumn+1, yytext());
}

"||" {
    TablaTokens.agregar("OR", yytext(), yyline, yycolumn);
    return new Symbol(sym.OR, yyline+1, yycolumn+1, yytext());
}

"!" {
    TablaTokens.agregar("NOT", yytext(), yyline, yycolumn);
    return new Symbol(sym.NOT, yyline+1, yycolumn+1, yytext());
}

// SÍMBOLOS

"{" { 
    TablaTokens.agregar("LLAVE_A", yytext(), yyline, yycolumn);
    return new Symbol(sym.LLAVE_A, yyline+1, yycolumn+1, yytext()); }

"}" { 
    TablaTokens.agregar("LLAVE_C", yytext(), yyline, yycolumn);
    return new Symbol(sym.LLAVE_C, yyline+1, yycolumn+1, yytext()); }

"(" { 
    TablaTokens.agregar("PAR_A", yytext(), yyline, yycolumn);
    return new Symbol(sym.PAR_A, yyline+1, yycolumn+1, yytext()); }

")" {
    TablaTokens.agregar("PAR_C", yytext(), yyline, yycolumn);
    return new Symbol(sym.PAR_C, yyline+1, yycolumn+1, yytext()); }

"[" { 
    TablaTokens.agregar("COR_A", yytext(), yyline, yycolumn);
    return new Symbol(sym.COR_A, yyline+1, yycolumn+1, yytext()); }

"]" { 
    TablaTokens.agregar("COR_C", yytext(), yyline, yycolumn);
    return new Symbol(sym.COR_C, yyline+1, yycolumn+1, yytext()); }

":" { 
    TablaTokens.agregar("DOSPT", yytext(), yyline, yycolumn);
    return new Symbol(sym.DOSPT, yyline+1, yycolumn+1, yytext()); }

";" { 
    TablaTokens.agregar("PTCOMA", yytext(), yyline, yycolumn);
    return new Symbol(sym.PTCOMA, yyline+1, yycolumn+1, yytext()); }

"," { 
    TablaTokens.agregar("COMA", yytext(), yyline, yycolumn);
    return new Symbol(sym.COMA, yyline+1, yycolumn+1, yytext()); }

"=" { 
    TablaTokens.agregar("ASIG", yytext(), yyline, yycolumn);
    return new Symbol(sym.ASIG, yyline+1, yycolumn+1, yytext()); }

// LITERALES

{DEC} {
    TablaTokens.agregar("DECIMAL", yytext(), yyline, yycolumn);
    return new Symbol(sym.DECIMAL, yyline+1, yycolumn+1, yytext());
}

{D} {
    TablaTokens.agregar("ENTERO", yytext(), yyline, yycolumn);
    return new Symbol(sym.ENTERO, yyline+1, yycolumn+1, yytext());
}

{STRING} {
    TablaTokens.agregar("CADENA", yytext(), yyline, yycolumn);
    return new Symbol(sym.CADENA, yyline+1, yycolumn+1, yytext());
}

{ID} {
    TablaTokens.agregar("ID", yytext(), yyline, yycolumn);
    return new Symbol(sym.ID, yyline+1, yycolumn+1, yytext());
}

// COMENTARIOS  

{comentario1} { /* ignorar */ }

{comentario2} { /* ignorar */ }

// ESPACIOS 

[\t\r\n\f ] { /* ignorar */ }

// ERRORES

. {
    TablaErrores.agregar(
        "Lexico",
        "Caracter no reconocido: " + yytext(),
        yyline + 1,
        yycolumn + 1
    );

}
