package caretaker;

import java.util.Stack;
import memento.Memento;

public class Historial {

    private final Stack<Memento> estados;

    public Historial() {
        this.estados = new Stack<>();
    }

    public void guardarEstado(Memento memento) {
        estados.push(memento);
    }

    public boolean hayEstados() {
        return !estados.isEmpty();
    }

    public Memento obtenerUltimoEstado() {
        if (estados.isEmpty()) {
            return null;
        }
        return estados.pop();
    }

    public int cantidadEstados() {
        return estados.size();
    }
}