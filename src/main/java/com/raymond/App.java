package com.raymond;

import com.raymond.memento.Caretaker;
import com.raymond.memento.Juego;
import com.raymond.memento.Originator;

public class App {

    public static void main(String[] args) {
        String nombreJuego="Crash Bandicoot";

        Juego juego=new Juego();
        juego.setNombre(nombreJuego);
        juego.setCheckpoint(1);

        Caretaker caretaker=new Caretaker();
        Originator originator=new Originator();

        juego=new Juego();
        juego.setNombre(nombreJuego);
        juego.setCheckpoint(2);
        originator.setEstado(juego);

        juego=new Juego();
        juego.setNombre(nombreJuego);
        juego.setCheckpoint(3);
        originator.setEstado(juego);

        caretaker.addMemento(originator.guardar()); //ESTADO POSICIÓN 0

        juego=new Juego();
        juego.setNombre(nombreJuego);
        juego.setCheckpoint(4);

        originator.setEstado(juego);
        caretaker.addMemento(originator.guardar()); //ESTADO POSICIÓN 1

        juego=new Juego();
        juego.setNombre(nombreJuego);
        juego.setCheckpoint(5);

        originator.setEstado(juego);
        originator.restaurar(caretaker.getMemento(1)); //RECUPERA ESTADO EN POSICIÓN index=1

        juego=originator.getEstado();
        System.out.println(juego);

    }
}
