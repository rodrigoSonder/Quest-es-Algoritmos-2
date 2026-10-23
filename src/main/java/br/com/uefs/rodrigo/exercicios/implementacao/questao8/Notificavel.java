package br.com.uefs.rodrigo.exercicios.implementacao.questao8;

/* 8. Implemente uma interface Notificavel com um método enviar(String mensagem).

Implemente duas classes que realizem essa interface:
• NotificacaoEmail, que recebe um endereço de e-mail no construtor.
• NotificacaoSMS, que recebe um número de telefone no construtor.
Cada classe deve implementar enviar(), imprimindo a mensagem e o respectivo destinatário.
Depois, escreva um método notificarTodos() que receba um vetor de Notificavel e uma
mensagem, enviando a mensagem para todos os elementos do vetor.
O objetivo é permitir adicionar novas formas de notificação sem precisar modificar o método
notificarTodos().

* */
public interface Notificavel {
    void enviar(String mensagem);
}

class NotificacaoEmail implements Notificavel {

    private String email;

    public NotificacaoEmail(String email) {
        this.email = email;
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println("Mensagem: " + mensagem);
        System.out.println("Destinatário: " + this.email);
    }
}

class NotificacaoSMS implements Notificavel {

    private String telefone;

    public NotificacaoSMS(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println("Mensagem: " + mensagem);
        System.out.println("Destinatário: " + telefone);
    }
}

class GerenciadorNotificacoes {

    public void notificarTodos(Notificavel[] notificavels, String mensagem) {

        for(Notificavel notificavel : notificavels) {

            notificavel.enviar(mensagem);
        }
    }
}

class Main {
    public static void main(String[] args) {

        Notificavel[] notificavels = {
                new NotificacaoSMS("+55 75 98360-6769"),
                new NotificacaoEmail("25211318@discente.uefs.br")
        };

        new GerenciadorNotificacoes()
                .notificarTodos(notificavels, "amo a uefs");
    }
}
