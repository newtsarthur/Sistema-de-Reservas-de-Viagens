// Atividade de Java

// Alunos: 
//     Arthur Belo da Silva (01615335)
//     Rodolpho Dihego (01599420)
//     Lucas Samuel Pereira Alves (01574914)
//     João gunttemberg de Almeida Coimbra - (01611681)

import java.util.ArrayList;

class Reserva {
    private String cliente;
    private String destino;
    private String dataViagem;

    public Reserva(String cliente, String destino, String dataViagem) {
        this.cliente = cliente;
        this.destino = destino;
        this.dataViagem = dataViagem;
    }

    public String getCliente() {
        return cliente;
    }

    public String getDestino() {
        return destino;
    }

    public String getDataViagem() {
        return dataViagem;
    }

    public double calcularCustoTotal() {
        // Implementação padrão para o custo total
        return 0.0;
    }
}

class PassagemAerea extends Reserva {
    private String companhiaAerea;

    public PassagemAerea(String cliente, String destino, String dataViagem, String companhiaAerea) {
        super(cliente, destino, dataViagem);
        this.companhiaAerea = companhiaAerea;
    }

    public String getCompanhiaAerea() {
        return companhiaAerea;
    }

    @Override
    public double calcularCustoTotal() {
        // Custo base para a passagem aérea
        double custoBase = 300.0;

        // Custo adicional com base na companhia aérea
        double custoCompanhia = 0.0;
        if (companhiaAerea.equals("CompanhiaA")) {
            custoCompanhia = 100.0;
        } else if (companhiaAerea.equals("CompanhiaB")) {
            custoCompanhia = 120.0;
        }

        return custoBase + custoCompanhia;
    }
}

class ReservaHotel extends Reserva {
    private String tipoQuarto;

    public ReservaHotel(String cliente, String destino, String dataViagem, String tipoQuarto) {
        super(cliente, destino, dataViagem);
        this.tipoQuarto = tipoQuarto;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    @Override
    public double calcularCustoTotal() {
        // Custo base para a reserva de hotel
        double custoBase = 150.0;

        // Custo adicional com base no tipo de quarto
        double custoQuarto = 0.0;
        if (tipoQuarto.equals("QuartoLuxo")) {
            custoQuarto = 50.0;
        } else if (tipoQuarto.equals("QuartoExecutivo")) {
            custoQuarto = 70.0;
        }

        return custoBase + custoQuarto;
    }
}

public class Main {
    public static void main(String[] args) {
        // Instanciamento de objetos
        PassagemAerea passagem = new PassagemAerea("Cliente1", "Destino1", "2023-01-01", "CompanhiaA");
        ReservaHotel reservaHotel = new ReservaHotel("Cliente2", "Destino2", "2023-02-01", "QuartoLuxo");

        // Teste de polimorfismo
        ArrayList<Reserva> reservas = new ArrayList<>();
        reservas.add(passagem);
        reservas.add(reservaHotel);

        // Chamada polimórfica ao método calcularCustoTotal
        for (Reserva reserva : reservas) {
            System.out.println("Cliente: " + reserva.getCliente());
            System.out.println("Destino: " + reserva.getDestino());
            System.out.println("Data Viagem: " + reserva.getDataViagem());
            System.out.println("Custo Total: $" + reserva.calcularCustoTotal());
            System.out.println("------------");
        }
    }
}
