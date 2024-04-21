package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaRepo implements Serializable {
    private List<PessoaFisica> listaPessoasFisicas;

    public PessoaFisicaRepo() {
        this.listaPessoasFisicas = new ArrayList<>();
    }

    public void inserir(PessoaFisica pessoa) {
        listaPessoasFisicas.add(pessoa);
    }

    public void alterar(PessoaFisica pessoa) {
        for (int i = 0; i < listaPessoasFisicas.size(); i++) {
            if (listaPessoasFisicas.get(i).getId() == pessoa.getId()) {
                listaPessoasFisicas.set(i, pessoa);
                return;
            }
        }
    }

    public void excluir(int id) {
        listaPessoasFisicas.removeIf(pessoa -> pessoa.getId() == id);
    }

    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoa : listaPessoasFisicas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    public List<PessoaFisica> obterTodos() {
        return listaPessoasFisicas;
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(listaPessoasFisicas);
        }
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaPessoasFisicas = (List<PessoaFisica>) ois.readObject();
        }
    }
    
     public int nextId() {
         if(listaPessoasFisicas.size() == 0) {
            return 1;
         }
         
        PessoaFisica ultimoElemento = listaPessoasFisicas.get(listaPessoasFisicas.size() - 1); 
        return ultimoElemento.getId() + 1; 
     }

}