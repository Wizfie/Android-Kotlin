package data

sealed class Operation(val name : String)

class Pluss : Operation("Plus")
class Minus : Operation("Minus")
class Modulo : Operation("Modulo")