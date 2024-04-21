package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaRepo implements Serializable {
    private List<PessoaJuridica> listaPessoasJuridicas;

    public PessoaJuridicaRepo() {
        this.listaPessoasJuridicas = new ArrayList<>();
    }

    public void inserir(PessoaJuridica pessoa) {
        listaPessoasJuridicas.add(pessoa);
    }

    public void alterar(PessoaJuridica pessoa) {
        for (int i = 0; i < listaPessoasJuridicas.size(); i++) {
            if (listaPessoasJuridicas.get(i).getId() == pessoa.getId()) {
                listaPessoasJuridicas.set(i, pessoa);
                return;
            }
        }
    }

    public void excluir(int id) {
        listaPessoasJuridicas.removeIf(pessoa -> pessoa.getId() == id);
    }

    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pessoa : listaPessoasJuridicas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    public List<PessoaJuridica> obterTodos() {
        return listaPessoasJuridicas;
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(listaPessoasJuridicas);
        }
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaPessoasJuridicas = (List<PessoaJuridica>) ois.readObject();
        }
    }
    
    public int nextId() {
        PessoaJuridica ultimoElemento = listaPessoasJuridicas.get(listaPessoasJuridicas.size() - 1); // Obtém o último elemento da lista
        System.out.println(ultimoElemento.getId() + 1);
        return ultimoElemento.getId() + 1; // Obtém o ID do último elemento
    }
}