package com.polytechnique.tpfinalpoo2.exception;


/**
 * Exception personnalisée lancée lorsque la capacité maximale d'un événement est atteinte
 */
public class CapaciteMaxAtteinteException extends Exception {
    public CapaciteMaxAtteinteException(String message) {
        super(message);
    }
}