package AbstraindoBootcamp;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Evento curso1 = new Curso("Curso java fundamentos", "Aborda todos os conceitos de java", 60);
        Evento curso2 = new Curso("Curso java intermediario", "Aborda todos os conceitos de java", 60);

        Evento curso3 = new Curso("Curso .NET fundamentos", "Aborda todos os conceitos de .NET", 70);
        Evento curso4 = new Curso("Curso .NET avançado", "Aborda todos os conceitos de .NET", 70);

        Evento mentoria1 = new Mentoria("POO", "Abordar conceitos de POO", LocalDate.now());

        Evento mentoria2 = new Mentoria("API com Spring", "Abordar conceitos de API REST com Spring", LocalDate.now());

        Bootcamp cognizant = new Bootcamp("Bootcamp Java Cognizant", "Aprenda Java zero ao Junior");
        cognizant.getEventos().add(curso1);
        cognizant.getEventos().add(curso2);

        Bootcamp localiza = new Bootcamp("Bootcamp .NET Localiza", "Aprenda .NET zero ao Junior");
        localiza.getEventos().add((curso3));
        localiza.getEventos().add((curso4));

        Dev dev1 = new Dev("Eduardo");
        dev1.inscriverBootcamp(cognizant);
        dev1.progredir();
        dev1.Apresenta();

        Dev dev2 = new Dev("Leonardo");
        dev2.inscriverBootcamp(localiza);
        dev2.progredir();
        dev2.Apresenta();
    }
}

