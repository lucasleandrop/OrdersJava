package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String nome;
    private String email;
    private Date birthDate;

    public Client(String nome, String email, Date birthDate) {
        this.nome = nome;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Client() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        String dataFormatada = sdf.format(birthDate);
        return nome + " - E-mail: " + email + " - ano de nascimento: "+ dataFormatada;

    }
}
