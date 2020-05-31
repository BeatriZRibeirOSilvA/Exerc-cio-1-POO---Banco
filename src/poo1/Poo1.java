
package poo1;

import javax.swing.JOptionPane;

public class Poo1 {

    public static void main(String[] args) {
        Banco dados = new Banco();
        
        dados.setAgencia(Integer.parseInt(JOptionPane.showInputDialog("Digite o número da sua agência: ")));
        dados.setNumConta(Integer.parseInt(JOptionPane.showInputDialog("Digite o número da sua conta: "))); 
        dados.setSenha(JOptionPane.showInputDialog("Digite a sua senha: "));
        
        dados.logar(dados.getAgencia(), dados.getNumConta(), dados.getSenha());
    }
    
}
