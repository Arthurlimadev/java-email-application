package emailapp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "company.com";

    // Construtor para receber o primeiro e ultimo nome.
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Chamar o método perguntando pelo departamento e retornar o departamento
        this.department = setDepartment();

        // Chamar o método que retorna uma senha aleatória
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Sua senha é: " + this.password);

        // Combinar elementos para gerar um e-mail
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() +  "@" + department + "." + companySuffix;
    }

    // Perguntar ao departamento
    private String setDepartment(){
        System.out.print("Novo funcionário: " + firstName + lastName + "Coloque o departamento\n" +
                "1 de Vendas\n2 para Desenvolvimento\n3 para Contabilidade\n0 Nenhum departamento\n" +
                "Coloque o código do departamento: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) { return "Vendas"; }
        else if (depChoice == 2) { return "Desenvolvimento"; }
        else if (depChoice == 3) { return "Contabilidade"; }
        else { return ""; }
    }

    // Gerar uma senha aleatória
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
           int rand = (int) (Math.random() * passwordSet.length());
           password[i] = passwordSet.charAt(rand);

        }
        return new String(password);
    }

    // Setar a capacidade da mailbox
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public int getMailboxCapacity() { return mailboxCapacity; }

    // Setar o email alternativo
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    public String getAlternateEmail() { return alternateEmail; };

    // Mudar a senha
    public void changePassword(String password) {
        this.password = password;
    }

    public String getPassword() { return password; }

    public String showInfo() {
        return "Mostrar nome: " + firstName + " " + lastName + "\n" +
                "Email da empresa : " + email + "\n" +
                "Capacidade da mailbox : " + mailboxCapacity + "mb";
    }

}
