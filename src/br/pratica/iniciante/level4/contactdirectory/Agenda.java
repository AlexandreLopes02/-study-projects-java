package br.pratica.iniciante.level4.contactdirectory;

import java.util.ArrayList;

public class Agenda {

    private ArrayList<Contact> contacts = new ArrayList<>();

    public void adicionarContact(Contact contact){
        for (Contact c : contacts){
            if (c.getNome().equalsIgnoreCase(contact.getNome())){
                System.out.println("⚠ Já existe um contato com esse nome!");
                return;
            }
        }
        this.contacts.add(contact);
        System.out.println("Contato adicionado com sucesso.");
    }

    public void removerContact(String nome){
        boolean removido = contacts.removeIf(c -> c.getNome().equalsIgnoreCase(nome));
        if (removido){
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("⚠ Contato não encrontado. Digite o nome de um contato que tenha registrado!");
        }
    }

    public void buscarContact(String nome){
        boolean encontrado = false;
        for (Contact c : contacts){
            if (c.getNome().equalsIgnoreCase(nome)){
                System.out.println("Contato encontrado: " + c);
                encontrado = true;
                break;
            }
        } if (!encontrado){
            System.out.println("⚠ Contato não encontrado!");
        }
    }


    public void listarContact(){
        if(contacts.isEmpty()){
            System.out.println("Agenda vazia");
        } else {
            System.out.println("Lista de contatos: ");
            for (int i = 0; i < contacts.size(); i++){
                System.out.printf("%d - %s%n", i + 1, contacts.get(i));
            }
        }
    }
}
