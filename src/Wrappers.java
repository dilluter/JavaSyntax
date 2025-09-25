public class Wrappers {
    public static void main(String[] args) {
        // Boxing (int -> Integer)
        int x = 10;
        Integer obj = x;

        // Unboxing (Integer -> int)
        int y = obj;

        System.out.println("Boxing: " + obj);
        System.out.println("Unboxing: " + y);

        // Wrapper classes possuem métodos extras
        String numero = "42";
        int valor = Integer.parseInt(numero);
        System.out.println("String para int: " + valor);
    }
}

