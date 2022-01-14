package AbstraindoBootcamp;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Evento> eventosInscritos = new LinkedHashSet<>();
    private Set<Evento> eventosConcluidos = new LinkedHashSet<>();

    public Dev(String nome) {
        this.nome = nome;
    }

    public void inscriverBootcamp(Bootcamp bootcamp) {
        this.eventosInscritos.addAll(bootcamp.getEventos());
        bootcamp.getDevInscritos().add(this);
    }

    public void progredir(){
        Optional<Evento> evento = this.eventosInscritos.stream().findFirst();
        if(evento.isPresent()){
            this.eventosConcluidos.add(evento.get());
            this.eventosInscritos.remove(evento.get());
        }else{
            System.out.println("Voc~e não esta matriculado em nenhum evento");
        }
    }

    public double calcularTotalXp(){
        return this.eventosConcluidos
                .stream()
                .mapToDouble(Evento::calcularXp)
                .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Evento> getEventosInscritos() {
        return eventosInscritos;
    }

    public void setEventosInscritos(Set<Evento> eventosInscritos) {
        this.eventosInscritos = eventosInscritos;
    }

    public Set<Evento> getEventosConcluidos() {
        return eventosConcluidos;
    }

    public void setEventosConcluidos(Set<Evento> eventosConcluidos) {
        this.eventosConcluidos = eventosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(eventosInscritos, dev.eventosInscritos) && Objects.equals(eventosConcluidos, dev.eventosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, eventosInscritos, eventosConcluidos);
    }

    public void Apresenta(){
        System.out.println(this.getNome()+", seus conteúdos inscritos: "+this.eventosInscritos);
        System.out.println(this.getNome()+", seus conteúdos concluídos: "+this.eventosConcluidos);
        System.out.println(this.getNome()+", seus XP's: "+this.calcularTotalXp());
    }
}