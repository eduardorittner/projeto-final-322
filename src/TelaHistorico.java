import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaHistorico extends JPanel {
        private String prot = "0";
        private String carb = "0";
        private String gor = "0";
        private String cal = "0";
        private DefaultListModel<Alimento> modelo;
        private JList<Alimento> lista;

        public TelaHistorico(Usuario u) {
                JPanel painelPrincipal = new JPanel();
                painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
                // Passar os macros como o formato de string (MUDAR COM .FORMAT OU .TOSTRING)
                // ListaRef listaRefeicoes = new ListaRef(TelaHistorico.this);
                JPanel macros = new JPanel();
                macros.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
                // Painel de proteinas
                JPanel calorias = new JPanel();
                calorias.setLayout(new BoxLayout(calorias, BoxLayout.Y_AXIS));
                PainelCircular calo = new PainelCircular(cal);
                JLabel c = new JLabel("Calorias");
                c.setAlignmentX(Component.CENTER_ALIGNMENT);
                calorias.add(calo);
                calorias.add(c);
                c.setBorder(new EmptyBorder(0, 5, 0, 0));
                JPanel proteina = new JPanel();
                proteina.setLayout(new BoxLayout(proteina, BoxLayout.Y_AXIS));
                // this.prot = getProtTotais();
                PainelCircular proteinas = new PainelCircular(prot);
                JLabel pro = new JLabel("Proteínas");
                pro.setAlignmentX(Component.CENTER_ALIGNMENT);
                pro.setBorder(new EmptyBorder(0, 5, 0, 0));
                proteina.add(proteinas);
                proteina.add(pro);
                // Painel de carboidratos
                JPanel carboidratos = new JPanel();
                carboidratos.setLayout(new BoxLayout(carboidratos, BoxLayout.Y_AXIS));
                // this.carb = getCarbsTotais();
                PainelCircular carbo = new PainelCircular(carb);
                JLabel carb = new JLabel("Carboidratos");
                carb.setAlignmentX(Component.CENTER_ALIGNMENT);
                carb.setBorder(new EmptyBorder(0, 5, 0, 0));
                carboidratos.add(carbo);
                carboidratos.add(carb);
                // Painel de gorduras
                JPanel gordura = new JPanel();
                gordura.setLayout(new BoxLayout(gordura, BoxLayout.Y_AXIS));
                // this.gor = getGordTotais();
                PainelCircular gorduras = new PainelCircular(gor);
                JLabel gor = new JLabel("Gorduras");
                gor.setAlignmentX(Component.CENTER_ALIGNMENT);
                gor.setBorder(new EmptyBorder(0, 5, 0, 0));
                gordura.add(gorduras);
                gordura.add(gor);
                JPanel painelHistorico = new JPanel();
                painelHistorico.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));
                painelHistorico.setPreferredSize(new Dimension(290, 500));
                painelHistorico.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                // Adicionando na Panel geral dos macros
                macros.add(proteina);
                macros.add(carboidratos);
                macros.add(gordura);
                macros.add(calorias);
                painelPrincipal.add(macros);
                // painelPrincipal.add(listaRefeicoes);
                add(painelPrincipal);
                modelo = new DefaultListModel<>();
                lista = new JList<>(modelo);
                try {
                        BufferedReader leitor = new BufferedReader(new FileReader(u.getUsername() + ".csv"));
                        String linha;
                        int contador = 0;
                        while (((linha = leitor.readLine()) != null)) {
                                if (contador != 0) {
                                        String[] var = linha.split(", ");
                                        ArrayList<String> dadosIn = new ArrayList<String>();
                                        for (int i = 0; i < var.length; i++) {
                                                dadosIn.add(var[i].split(": ")[1]);
                                        }
                                        Ingrediente alimento = new Ingrediente(dadosIn.get(0),
                                                        Double.parseDouble(dadosIn.get(1)),
                                                        Double.parseDouble(dadosIn.get(2)),
                                                        Double.parseDouble(dadosIn.get(3)),
                                                        Double.parseDouble(dadosIn.get(4)),
                                                        Double.parseDouble(dadosIn.get(5)));
                                        modelo.addElement(alimento);
                                        alimento.calcularMacros();
                                        atualizarDados(proteinas, carbo, gorduras, calo);
                                }
                                contador++;
                        }
                        leitor.close();
                } catch (IOException e) {
                }
                setLayout(new BoxLayout(TelaHistorico.this, BoxLayout.Y_AXIS));
                JButton add = new JButton("Adicionar");
                add.addActionListener((ActionListener) new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                JFrame escolha = new JFrame();
                                escolha.setSize(390, 195);
                                JButton ingrediente = new JButton("Ingrediente");
                                JButton receita = new JButton("Receita");
                                JPanel painel = new JPanel();
                                painel.add(ingrediente);
                                painel.add(receita);

                                ingrediente.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                                escolha.dispose();
                                                JFrame input = new JFrame();
                                                input.setSize(390, 844);
                                                JPanel painelPrincipal = new JPanel();
                                                painelPrincipal.setLayout(
                                                                new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
                                                JLabel nome = new JLabel("Nome");
                                                JTextField nomeInput = new JTextField(20);
                                                JLabel peso = new JLabel("Peso");
                                                JTextField pesoInput = new JTextField(20);
                                                JLabel carbs = new JLabel("Carboidratos");
                                                JTextField carbInput = new JTextField(20);
                                                JLabel prots = new JLabel("Proteínas");
                                                JTextField protsInput = new JTextField(20);
                                                JLabel gord = new JLabel("Gorduras");
                                                JTextField gordInput = new JTextField(20);
                                                JLabel cal = new JLabel("Calorias");
                                                JTextField calInput = new JTextField(20);
                                                painelPrincipal.add(nome);
                                                painelPrincipal.add(nomeInput);
                                                painelPrincipal.add(peso);
                                                painelPrincipal.add(pesoInput);
                                                painelPrincipal.add(carbs);
                                                painelPrincipal.add(carbInput);
                                                painelPrincipal.add(prots);
                                                painelPrincipal.add(protsInput);
                                                painelPrincipal.add(gord);
                                                painelPrincipal.add(gordInput);
                                                painelPrincipal.add(cal);
                                                painelPrincipal.add(calInput);
                                                painelPrincipal.setVisible(true);
                                                JButton ok = new JButton("OK");
                                                ok.addActionListener(new ActionListener() {
                                                        public void actionPerformed(ActionEvent e) {
                                                                String nome1 = nomeInput.getText();
                                                                double peso1 = Double.parseDouble(pesoInput.getText());
                                                                double carbs1 = Double.parseDouble(carbInput.getText());
                                                                double prots1 = Double.parseDouble(protsInput.getText());
                                                                double gords1 = Double.parseDouble(gordInput.getText());
                                                                double cal1 = Double.parseDouble(calInput.getText());
                                                                Ingrediente alimento = new Ingrediente(nome1, prots1, gords1, carbs1,cal1, peso1);
                                                                modelo.addElement(alimento);
                                                                input.dispose();
                                                                alimento.calcularMacros();
                                                                atualizarDados(proteinas, carbo, gorduras, calo);
                                                                u.salvarHistorico(alimento);
                                                        }
                                                });
                                                painelPrincipal.add(ok);
                                                input.add(painelPrincipal);
                                                input.setVisible(true);
                                        }
                                });

                                receita.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                                escolha.dispose();
                                                JFrame novaReceita = new JFrame();
                                                JPanel painelReceita = new JPanel();
                                                novaReceita.setSize(390, 390);
                                                JLabel tituloReceita = new JLabel("Nome da receita");
                                                JTextField nomeReceitaInput = new JTextField(20);
                                                JLabel tituloPorcao = new JLabel("Porção (g)");
                                                JTextField porcaoInput = new JTextField(20);
                                                JButton ok = new JButton("OK");
                                                painelReceita.add(tituloReceita);
                                                painelReceita.add(nomeReceitaInput);
                                                painelReceita.add(tituloPorcao);
                                                painelReceita.add(porcaoInput);
                                                painelReceita.add(ok);
                                                ok.addActionListener(new ActionListener() {
                                                        public void actionPerformed(ActionEvent e) {
                                                                String nomeReceita = nomeReceitaInput.getText();
                                                                double porcao = Double
                                                                                .parseDouble(porcaoInput.getText());
                                                                Receita receita = new Receita(nomeReceita, 0, 0, 0, 0,porcao);
                                                                novaReceita.dispose();
                                                                JFrame input = new JFrame();
                                                                input.setSize(390, 844);
                                                                JPanel painelPrincipal = new JPanel();
                                                                painelPrincipal.setLayout(new BoxLayout(painelPrincipal,BoxLayout.Y_AXIS));
                                                                JLabel nome = new JLabel("Nome");
                                                                JTextField nomeInput = new JTextField(20);
                                                                JLabel peso = new JLabel("Peso");
                                                                JTextField pesoInput = new JTextField(20);
                                                                JLabel carbs = new JLabel("Carboidratos");
                                                                JTextField carbInput = new JTextField(20);
                                                                JLabel prots = new JLabel("Proteínas");
                                                                JTextField protsInput = new JTextField(20);
                                                                JLabel gord = new JLabel("Gorduras");
                                                                JTextField gordInput = new JTextField(20);
                                                                JLabel cal = new JLabel("Calorias");
                                                                JTextField calInput = new JTextField(20);
                                                                painelPrincipal.add(nome);
                                                                painelPrincipal.add(nomeInput);
                                                                painelPrincipal.add(peso);
                                                                painelPrincipal.add(pesoInput);
                                                                painelPrincipal.add(carbs);
                                                                painelPrincipal.add(carbInput);
                                                                painelPrincipal.add(prots);
                                                                painelPrincipal.add(protsInput);
                                                                painelPrincipal.add(gord);
                                                                painelPrincipal.add(gordInput);
                                                                painelPrincipal.add(cal);
                                                                painelPrincipal.add(calInput);
                                                                painelPrincipal.setVisible(true);
                                                                JButton ok = new JButton("OK");
                                                                ok.addActionListener(new ActionListener() {
                                                                        public void actionPerformed(ActionEvent e) {
                                                                                String nome1 = nomeInput.getText();
                                                                                double peso1 = Double.parseDouble(pesoInput.getText());
                                                                                double carbs1 = Double.parseDouble(carbInput.getText());
                                                                                double prots1 = Double.parseDouble(protsInput.getText());
                                                                                double gords1 = Double.parseDouble(gordInput.getText());
                                                                                double cal1 = Double.parseDouble(calInput.getText());
                                                                                Ingrediente alimento = new Ingrediente(
                                                                                                nome1, prots1,
                                                                                                gords1, carbs1,
                                                                                                cal1, peso1);
                                                                                alimento.calcularMacros();
                                                                                atualizarDados(proteinas, carbo,
                                                                                                gorduras, calo);
                                                                                resetarInput(nomeInput, pesoInput, carbInput, protsInput, gordInput, calInput);
                                                                                try {
                                                                                        receita.adicionarIngrediente(alimento);
                                                                                } catch (Exception error) {
                                                                                }
                                                                        
                                                                        }
                                                                });

                                                                JButton finalizar = new JButton("Finalizar");

                                                                finalizar.addActionListener(new ActionListener() {
                                                                        public void actionPerformed(ActionEvent e) {
                                                                                input.dispose();
                                                                                modelo.addElement(receita);
                                                                                receita.calcularMacros();
                                                                                u.salvarHistorico(receita);
                                                                }
                                                                });
                                                                painelPrincipal.add(ok);
                                                                painelPrincipal.add(finalizar);
                                                                input.add(painelPrincipal);
                                                                input.setVisible(true);
                                                        }
                                                });
                                                novaReceita.add(painelReceita);
                                                novaReceita.setVisible(true);
                                        }
                                });
                                escolha.add(painel);
                                escolha.setVisible(true);

                        }
                });
                JButton remove = new JButton("Remover");
                remove.addActionListener((ActionListener) new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                JFrame input = new JFrame();
                                input.setSize(300, 300);
                                JPanel painelPrincipal = new JPanel();
                                painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
                                JLabel nome = new JLabel("Insira o nome do ingrediente a ser removido: ");
                                JTextField nomeInput = new JTextField(20);
                                JButton ok = new JButton("OK");
                                ok.addActionListener(new ActionListener() {
                                        boolean entrou = false;

                                        public void actionPerformed(ActionEvent e) {
                                                for (int i = 0; i < modelo.size(); i++) {
                                                        if (modelo.get(i).getNome().equals(nomeInput.getText())) {
                                                                modelo.removeElement(modelo.get(i));
                                                                entrou = true;
                                                                input.dispose();
                                                                modelo.get(i).calcularMacros();
                                                                atualizarDados(proteinas, carbo, gorduras, calo);
                                                        }
                                                }
                                                if (!entrou) {
                                                        JOptionPane.showMessageDialog(TelaHistorico.this,
                                                                        "Ingrediente não encontrado!");
                                                }
                                        }
                                });
                                painelPrincipal.add(nome);
                                painelPrincipal.add(nomeInput);
                                painelPrincipal.add(ok);
                                input.add(painelPrincipal);
                                input.setVisible(true);
                        }
                });
                add(new JScrollPane(lista), BorderLayout.CENTER);
                JButton resetar = new JButton("Limpar Dia");
                resetar.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                modelo.removeAllElements();
                                atualizarDados(proteinas, carbo, gorduras, calo);
                                try {
                                        String nomeArquivo = u.getUsername() + ".csv";
                                        File atual = new File(nomeArquivo);
                                        File tempFile = new File("temp.csv");
                                        BufferedWriter escritor = new BufferedWriter(new FileWriter("temp.csv"));
                                        BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
                                        int contador = 1;
                                        String linha;
                                        while (((linha = leitor.readLine()) != null) && contador != 0) {
                                                escritor.write(linha);
                                                contador--;
                                        }
                                        escritor.close();
                                        leitor.close();
                                        atual.delete();
                                        tempFile.renameTo(atual);
                                } catch (IOException es) {
                                }
                        }
                });
                JButton exportar = new JButton("Exportar Dia");
                exportar.addActionListener(new ActionListener() {
                        public void actionPerformed(Action e) {
                                
                        }
                });
                JPanel botoes = new JPanel();
                botoes.setLayout(new BoxLayout(botoes, BoxLayout.X_AXIS));
                botoes.add(add);
                botoes.add(remove);
                botoes.add(resetar);
                add(botoes);

        }

        /**
         * @return the prot
         */
        public String getProt() {
                return prot;
        }

        /**
         * @param prot the prot to set
         */
        public void setProt(String prot) {
                this.prot = prot;
        }

        /**
         * @return the carb
         */
        public String getCarb() {
                return carb;
        }

        /**
         * @param carb the carb to set
         */
        public void setCarb(String carb) {
                this.carb = carb;
        }

        /**
         * @return the cal
         */
        public String getCal() {
                return cal;
        }

        /**
         * @param cal the cal to set
         */
        public void setCal(String cal) {
                this.cal = cal;
        }

        /**
         * @return the modelo
         */
        public DefaultListModel<Alimento> getModelo() {
                return modelo;
        }

        /**
         * @param modelo the modelo to set
         */
        public void setModelo(DefaultListModel<Alimento> modelo) {
                this.modelo = modelo;
        }

        /**
         * @return the lista
         */
        public JList<Alimento> getLista() {
                return lista;
        }

        /**
         * @param lista the lista to set
         */
        public void setLista(JList<Alimento> lista) {
                this.lista = lista;
        }

        /**
         * @return the gor
         */
        public String getGor() {
                return gor;
        }

        /**
         * @param gor the gor to set
         */
        public void setGor(String gor) {
                this.gor = gor;
        }

        public String getProtTotais() {
                double total = 0.00;
                for (int i = 0; i < modelo.size(); i++) {
                        total += modelo.get(i).getMacros().getProt();
                }
                return String.format("%.2f", total);
        }

        public String getGordTotais() {
                double total = 0.00;
                for (int i = 0; i < modelo.size(); i++) {
                        total += modelo.get(i).getMacros().getFat();
                }
                return String.format("%.2f", total);
        }

        public String getCarbsTotais() {
                double total = 0.00;
                for (int i = 0; i < modelo.size(); i++) {
                        total += modelo.get(i).getMacros().getCarb();
                }
                return String.format("%.2f", total);
        }

        public String getCaloriasTotais() {
                double total = 0.00;
                for (int i = 0; i < modelo.size(); i++) {
                        total += modelo.get(i).getMacros().getCal();
                }
                return String.format("%.2f", total);
        }

        public void atualizarDados(PainelCircular proteinas, PainelCircular carbo, PainelCircular gorduras,
                        PainelCircular calo) {
                proteinas.setData(TelaHistorico.this.getProtTotais());
                carbo.setData(TelaHistorico.this.getCarbsTotais());
                gorduras.setData(TelaHistorico.this.getGordTotais());
                calo.setData(TelaHistorico.this.getCaloriasTotais());
                proteinas.repaint();
                carbo.repaint();
                gorduras.repaint();
                calo.repaint();
        }

        public void resetarInput(JTextField nome, JTextField peso,JTextField carbo,JTextField prot,JTextField gor,JTextField cal){
                nome.setText("");
                peso.setText("");
                carbo.setText("");
                prot.setText("");
                gor.setText("");
                cal.setText("");
        }

}
