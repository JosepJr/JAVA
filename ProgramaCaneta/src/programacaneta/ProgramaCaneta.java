package programacaneta;

public class ProgramaCaneta {

    public static void main(String[] args) {
        Caneta C1 = new Caneta("aaa", "azul", true, 0.5f, 100);
        /*C1.carga = 100;
        C1.cor = "azul";
        C1.ponta = 0.5f;
        C1.modelo = "BIC";
        C1.tampada = true;
        */
        C1.status();
        C1.rabiscar();
    }
    
}
