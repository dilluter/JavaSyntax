import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DatasHorasJava {
    public static void main(String[] args) {

        // ================================
        // 1. Instanciando data-hora em Java
        // ================================
        LocalDate data = LocalDate.now(); // apenas a data atual
        LocalTime hora = LocalTime.now(); // apenas a hora atual
        LocalDateTime dataHora = LocalDateTime.now(); // data e hora atual

        System.out.println("Data atual: " + data);
        System.out.println("Hora atual: " + hora);
        System.out.println("Data e hora atual: " + dataHora);

        // ================================
        // 2. Timezone (fuso horário)
        // ================================
        ZonedDateTime sp = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        ZonedDateTime ny = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("\nSão Paulo: " + sp);
        System.out.println("Nova York: " + ny);

        // ================================
        // 3. Padrão ISO 8601 (formato padrão de datas)
        // ================================
        System.out.println("\nFormato ISO 8601: " + dataHora.toString());

        // ================================
        // 4. Formatando data-hora para TEXTO
        // ================================
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("Formatado: " + dataHora.format(formato));

        // ================================
        // 5. Convertendo de texto para data-hora
        // ================================
        String dataTexto = "25/09/2025 14:30:00";
        LocalDateTime convertida = LocalDateTime.parse(dataTexto, formato);
        System.out.println("Convertida de String: " + convertida);

        // ================================
        // 6. Convertendo data-hora global (UTC) para local
        // ================================
        Instant agoraUTC = Instant.now(); // UTC (padrão global)
        ZonedDateTime localSP = agoraUTC.atZone(ZoneId.of("America/Sao_Paulo"));
        System.out.println("\nUTC: " + agoraUTC);
        System.out.println("Convertida para SP: " + localSP);

        // ================================
        // 7. Operações importantes com data-hora
        // ================================
        LocalDate daquiUmaSemana = data.plusWeeks(1);
        LocalDate ontem = data.minusDays(1);
        System.out.println("\nHoje: " + data);
        System.out.println("Daqui uma semana: " + daquiUmaSemana);
        System.out.println("Ontem: " + ontem);

        // ================================
        // 8. Cálculos com data-hora
        // ================================
        LocalDate nascimento = LocalDate.of(2007, 5, 20);
        Period idade = Period.between(nascimento, data);
        System.out.println("\nIdade: " + idade.getYears() + " anos, " + idade.getMonths() + " meses, " + idade.getDays() + " dias");

        long diasEntre = ChronoUnit.DAYS.between(nascimento, data);
        System.out.println("Dias vividos: " + diasEntre);

        // ================================
        // 9. Usando Date e Calendar (antigo, não recomendado)
        // ================================
        java.util.Date dataAntiga = new java.util.Date();
        java.util.Calendar calendario = java.util.Calendar.getInstance();
        calendario.setTime(dataAntiga);

        System.out.println("\nAPI antiga:");
        System.out.println("Date: " + dataAntiga);
        System.out.println("Calendar: " + calendario.getTime());
    }
}
