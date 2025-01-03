package util;

import gerenciamentodeclientes.dominio.Cliente;

import java.util.Comparator;

public class OrdenaPorNome implements Comparator<Cliente> {

    @Override
    public int compare(Cliente o1, Cliente o2) {
        return o1.getNome().compareToIgnoreCase(o2.getNome());
    }
}
