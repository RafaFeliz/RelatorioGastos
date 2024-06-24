import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Gasto> gastos = new ArrayList<>();

        System.out.println("Informe seu salário:");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha

        System.out.println("Informe o valor fixo investido por            mês:");
        double investimentoFixo = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha

        while (true) {
            System.out.println("Informe o nome da atividade/gasto             (ou digite 'sair' para terminar):");
            String atividade = scanner.nextLine();
            if (atividade.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.println("Informe o valor gasto com " +                 atividade + ":");
            double valor = scanner.nextDouble();
            scanner.nextLine(); // Consumir a nova linha

            gastos.add(new Gasto(atividade, valor));
        }

        double totalGastos = 0;
        for (Gasto gasto : gastos) {
            totalGastos += gasto.getValor();
        }

        System.out.println("\nRelatório de Gastos:");
        for (Gasto gasto : gastos) {
            double porcentagem = (gasto.getValor() / salario) *               100;
            System.out.printf("%s: R$%.2f (%.2f%% do salário)\n",             gasto.getNome(), gasto.getValor(), porcentagem);
        }

        double porcentagemInvestimento = (investimentoFixo /              salario) * 100;
        System.out.printf("Investimento Fixo: R$%.2f (%.2f%% do           salário)\n", investimentoFixo, porcentagemInvestimento);

        double totalDespesas = totalGastos + investimentoFixo;
        double restante = salario - totalDespesas;
        double porcentagemRestante = (restante / salario) * 100;
        System.out.printf("\nTotal gasto: R$%.2f (%.2f%% do               salário)\n", totalDespesas, (totalDespesas / salario) *           100);
        System.out.printf("Restante: R$%.2f (%.2f%% do                    salário)\n", restante, porcentagemRestante);

        scanner.close();
    }
}