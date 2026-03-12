package src.Analizadores;

/** Clase generada para los símbolos del parser */
public class sym {

  /* TERMINALES */

  public static final int EOF = 0;
  public static final int error = 1;

  // PALABRAS RESERVADAS 
  public static final int DATABASE = 2;
  public static final int USE = 3;
  public static final int TABLE = 4;
  public static final int READ = 5;
  public static final int FIELDS = 6;
  public static final int FILTER = 7;
  public static final int ADD = 8;
  public static final int UPDATE = 9;
  public static final int CLEAR = 10;
  public static final int EXPORT = 11;
  public static final int STORE = 12;
  public static final int AT = 13;
  public static final int SET = 14;

  // TIPOS  
  public static final int INT = 15;
  public static final int FLOAT = 16;
  public static final int BOOL = 17;
  public static final int STRING_TYPE = 18;
  public static final int ARRAY = 19;
  public static final int OBJECT = 20;
  public static final int NULL = 21;

  // BOOLEANOS  
  public static final int TRUE = 22;
  public static final int FALSE = 23;

  // OPERADORES RELACIONALES 
  public static final int IGUAL = 24;
  public static final int DIFERENTE = 25;
  public static final int MAYOR = 26;
  public static final int MENOR = 27;
  public static final int MAYORIGUAL = 28;
  public static final int MENORIGUAL = 29;

  // OPERADORES LÓGICOS  
  public static final int AND = 30;
  public static final int OR = 31;
  public static final int NOT = 32;

  // SÍMBOLOS  
  public static final int LLAVE_A = 33;
  public static final int LLAVE_C = 34;

  public static final int PAR_A = 35;
  public static final int PAR_C = 36;

  public static final int COR_A = 37;
  public static final int COR_C = 38;

  public static final int DOSPT = 39;
  public static final int PTCOMA = 40;
  public static final int COMA = 41;

  public static final int ASIG = 42;

  // LITERALES  
  public static final int ID = 43;
  public static final int ENTERO = 44;
  public static final int DECIMAL = 45;
  public static final int CADENA = 46;

  // NOMBRES  
  public static final String[] terminalNames = new String[] {
      "EOF",
      "error",

      "DATABASE",
      "USE",
      "TABLE",
      "READ",
      "FIELDS",
      "FILTER",
      "ADD",
      "UPDATE",
      "CLEAR",
      "EXPORT",
      "STORE",
      "AT",
      "SET",

      "INT",
      "FLOAT",
      "BOOL",
      "STRING_TYPE",
      "ARRAY",
      "OBJECT",
      "NULL",

      "TRUE",
      "FALSE",

      "IGUAL",
      "DIFERENTE",
      "MAYOR",
      "MENOR",
      "MAYORIGUAL",
      "MENORIGUAL",

      "AND",
      "OR",
      "NOT",

      "LLAVE_A",
      "LLAVE_C",

      "PAR_A",
      "PAR_C",

      "COR_A",
      "COR_C",

      "DOSPT",
      "PTCOMA",
      "COMA",

      "ASIG",

      "ID",
      "ENTERO",
      "DECIMAL",
      "CADENA"
  };

}
