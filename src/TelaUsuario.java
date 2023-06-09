import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class TelaUsuario extends JPanel {
    private JLabel nomeLabel, idadeLabel, emailLabel, pesoLabel, alturaLabel, generoLabel, nomeField, 
                    idadeField, emailField, pesoField, alturaField, generoField;
    private JButton botaoEditar; 
    private JTabbedPane abas;
    private JLabel fotoLabel;
    private ImageIcon fotoIcon;
    private Usuario usuario;

    public TelaUsuario(Usuario u) {
        this.usuario = u;
        setLayout(new BorderLayout());

        abas = new JTabbedPane();

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());
        
        fotoLabel = new JLabel();
        fotoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fotoLabel.setVerticalAlignment(SwingConstants.CENTER);
        if (!usuario.getCaminhoFoto().equals(".")) {
            ImageIcon icone = new ImageIcon(usuario.getCaminhoFoto());
            fotoLabel.setIcon(new ImageIcon(icone.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
        }
        painelPrincipal.add(fotoLabel, BorderLayout.NORTH);
        
        JPanel painelFormatacao = new JPanel();
        painelFormatacao.setLayout(new GridLayout(6, 2));

        nomeLabel = new JLabel("Nome:");
        nomeField = new JLabel(usuario.getNome());
        idadeLabel = new JLabel("Idade:");
        idadeField = new JLabel(usuario.getIdade());
        generoLabel = new JLabel("Gênero:");
        generoField = new JLabel(usuario.getGenero());
        pesoLabel = new JLabel("Peso (Kg):");
        pesoField = new JLabel(usuario.getPeso());
        alturaLabel = new JLabel("Altura (cm):");
        alturaField = new JLabel(usuario.getAltura());
        emailLabel = new JLabel("Email:");
        emailField = new JLabel(usuario.getEmail());

        painelFormatacao.add(nomeLabel);
        painelFormatacao.add(nomeField);
        painelFormatacao.add(idadeLabel);
        painelFormatacao.add(idadeField);
        painelFormatacao.add(generoLabel);
        painelFormatacao.add(generoField);
        painelFormatacao.add(emailLabel);
        painelFormatacao.add(emailField);
        painelFormatacao.add(pesoLabel);
        painelFormatacao.add(pesoField);
        painelFormatacao.add(alturaLabel);
        painelFormatacao.add(alturaField);

        painelPrincipal.add(painelFormatacao, BorderLayout.CENTER);

        abas.addTab("Informações do Usuário", painelPrincipal);
        add(abas, BorderLayout.CENTER);

        botaoEditar = new JButton("Editar");
        botaoEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel painelEditar = new JPanel();
                painelEditar.setLayout(new BorderLayout());

                JLabel editFotoLabel = new JLabel();
                editFotoLabel.setHorizontalAlignment(SwingConstants.CENTER);
                editFotoLabel.setVerticalAlignment(SwingConstants.CENTER);
                painelEditar.add(editFotoLabel, BorderLayout.NORTH);

                JLabel editNomeLabel = new JLabel("Nome:");
                JTextField editNomeField = new JTextField();
                JLabel editIdadeLabel = new JLabel("Idade:");
                JTextField editIdadeField = new JTextField();
                JLabel editGeneroLabel = new JLabel("Gênero:");
                JTextField editGeneroField = new JTextField();
                JLabel editPesoLabel = new JLabel("Peso (Kg):");
                JTextField editPesoField = new JTextField();
                JLabel editAlturaLabel = new JLabel("Altura (cm):");
                JTextField editAlturaField = new JTextField();
                JLabel editEmailLabel = new JLabel("Email:");
                JTextField editEmailField = new JTextField();

                JPanel painelEditarAtributos = new JPanel();
                painelEditarAtributos.setLayout(new GridLayout(6, 2));
                painelEditarAtributos.add(editNomeLabel);
                painelEditarAtributos.add(editNomeField);
                painelEditarAtributos.add(editIdadeLabel);
                painelEditarAtributos.add(editIdadeField);
                painelEditarAtributos.add(editGeneroLabel);
                painelEditarAtributos.add(editGeneroField);
                painelEditarAtributos.add(editPesoLabel);
                painelEditarAtributos.add(editPesoField);
                painelEditarAtributos.add(editAlturaLabel);
                painelEditarAtributos.add(editAlturaField);
                painelEditarAtributos.add(editEmailLabel);
                painelEditarAtributos.add(editEmailField);

                painelEditar.add(painelEditarAtributos, BorderLayout.CENTER);

                JButton botaoCancelar = new JButton("Cancelar");
                botaoCancelar.addActionListener(new ActionListener () {
                    public void actionPerformed(ActionEvent e) {
                        abas.remove(painelEditar);
                    }
                });

                JButton botaoFoto = new JButton("Selecione uma foto");
                JFileChooser fileChooser = new JFileChooser();
                botaoFoto.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
                        fileChooser.setFileFilter(filter);

                        int result = fileChooser.showOpenDialog(null);
                        if (result == JFileChooser.APPROVE_OPTION) {
                            File fotoSelecionada = fileChooser.getSelectedFile();
                            ImageIcon iconeImagem = new ImageIcon(fotoSelecionada.getPath());
                            editFotoLabel.setIcon(new ImageIcon(iconeImagem.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
                        }
                    }
                });

                JButton botaoSalvar = new JButton("Salvar");
                botaoSalvar.addActionListener(new ActionListener () {
                    public void actionPerformed(ActionEvent e) {
                        String nomeEditado = editNomeField.getText();
                        String idadeEditado = editIdadeField.getText();
                        String emailEditado = editEmailField.getText();
                        String pesoEditado = editPesoField.getText();
                        String alturaEditado = editAlturaField.getText();
                        String generoEditado = editGeneroField.getText();
                        if (nomeEditado.isEmpty()) {
                            nomeEditado = nomeField.getText();
                        }
                        if (idadeEditado.isEmpty()) {
                            idadeEditado = idadeField.getText();
                        }
                        if (emailEditado.isEmpty()) {
                            emailEditado = emailField.getText();
                        }
                        if (pesoEditado.isEmpty()) {
                            pesoEditado = pesoField.getText();
                        }
                        if (alturaEditado.isEmpty()) {
                            alturaEditado = alturaField.getText();
                        }
                        if (generoEditado.isEmpty()) {
                         generoEditado = generoField.getText();   
                        }
                        
                        nomeField.setText(nomeEditado);
                        idadeField.setText(idadeEditado);
                        emailField.setText(emailEditado);
                        pesoField.setText(pesoEditado);
                        alturaField.setText(alturaEditado);
                        generoField.setText(generoEditado);

                        usuario.setNome(nomeEditado);
                        usuario.setIdade(idadeEditado);
                        usuario.setAltura(alturaEditado);
                        usuario.setPeso(pesoEditado);
                        usuario.setGenero(generoEditado);
                        usuario.setEmail(emailEditado);

                        File fotoEditadaFile = fileChooser.getSelectedFile();
                        if (fotoEditadaFile != null) {
                            fotoIcon = new ImageIcon(fotoEditadaFile.getPath());
                            fotoLabel.setIcon(new ImageIcon(fotoIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
                            usuario.setCaminhoFoto(fotoEditadaFile.getPath()+ "\n");
                        }

                        usuario.salvaUsuarios();
                        abas.remove(painelEditar);
                    }
                });

                JPanel painelBotoesEditar = new JPanel();
                painelBotoesEditar.add(botaoCancelar);
                painelBotoesEditar.add(botaoSalvar);
                painelBotoesEditar.add(botaoFoto);

                painelEditar.add(painelBotoesEditar, BorderLayout.SOUTH);

                abas.addTab("", painelEditar);
                abas.setSelectedComponent(painelEditar);
            }
        });

        add(botaoEditar, BorderLayout.SOUTH);
        setVisible(true);
    }

    /**
     * @return the nomeLabel
     */
    public JLabel getNomeLabel() {
        return nomeLabel;
    }

    /**
     * @param nomeLabel the nomeLabel to set
     */
    public void setNomeLabel(JLabel nomeLabel) {
        this.nomeLabel = nomeLabel;
    }

    /**
     * @return the idadeLabel
     */
    public JLabel getIdadeLabel() {
        return idadeLabel;
    }

    /**
     * @param idadeLabel the idadeLabel to set
     */
    public void setIdadeLabel(JLabel idadeLabel) {
        this.idadeLabel = idadeLabel;
    }

    /**
     * @return the emailLabel
     */
    public JLabel getEmailLabel() {
        return emailLabel;
    }

    /**
     * @param emailLabel the emailLabel to set
     */
    public void setEmailLabel(JLabel emailLabel) {
        this.emailLabel = emailLabel;
    }

    /**
     * @return the pesoLabel
     */
    public JLabel getPesoLabel() {
        return pesoLabel;
    }

    /**
     * @param pesoLabel the pesoLabel to set
     */
    public void setPesoLabel(JLabel pesoLabel) {
        this.pesoLabel = pesoLabel;
    }

    /**
     * @return the alturaLabel
     */
    public JLabel getAlturaLabel() {
        return alturaLabel;
    }

    /**
     * @param alturaLabel the alturaLabel to set
     */
    public void setAlturaLabel(JLabel alturaLabel) {
        this.alturaLabel = alturaLabel;
    }

    /**
     * @return the generoLabel
     */
    public JLabel getGeneroLabel() {
        return generoLabel;
    }

    /**
     * @param generoLabel the generoLabel to set
     */
    public void setGeneroLabel(JLabel generoLabel) {
        this.generoLabel = generoLabel;
    }

    /**
     * @return the nomeField
     */
    public JLabel getNomeField() {
        return nomeField;
    }

    /**
     * @param nomeField the nomeField to set
     */
    public void setNomeField(JLabel nomeField) {
        this.nomeField = nomeField;
    }

    /**
     * @return the idadeField
     */
    public JLabel getIdadeField() {
        return idadeField;
    }

    /**
     * @param idadeField the idadeField to set
     */
    public void setIdadeField(JLabel idadeField) {
        this.idadeField = idadeField;
    }

    /**
     * @return the emailField
     */
    public JLabel getEmailField() {
        return emailField;
    }

    /**
     * @param emailField the emailField to set
     */
    public void setEmailField(JLabel emailField) {
        this.emailField = emailField;
    }

    /**
     * @return the pesoField
     */
    public JLabel getPesoField() {
        return pesoField;
    }

    /**
     * @param pesoField the pesoField to set
     */
    public void setPesoField(JLabel pesoField) {
        this.pesoField = pesoField;
    }

    /**
     * @return the alturaField
     */
    public JLabel getAlturaField() {
        return alturaField;
    }

    /**
     * @param alturaField the alturaField to set
     */
    public void setAlturaField(JLabel alturaField) {
        this.alturaField = alturaField;
    }

    /**
     * @return the generoField
     */
    public JLabel getGeneroField() {
        return generoField;
    }

    /**
     * @param generoField the generoField to set
     */
    public void setGeneroField(JLabel generoField) {
        this.generoField = generoField;
    }

    /**
     * @return the botaoEditar
     */
    public JButton getBotaoEditar() {
        return botaoEditar;
    }

    /**
     * @param botaoEditar the botaoEditar to set
     */
    public void setBotaoEditar(JButton botaoEditar) {
        this.botaoEditar = botaoEditar;
    }

    /**
     * @return the abas
     */
    public JTabbedPane getAbas() {
        return abas;
    }

    /**
     * @param abas the abas to set
     */
    public void setAbas(JTabbedPane abas) {
        this.abas = abas;
    }

    /**
     * @return the fotoLabel
     */
    public JLabel getFotoLabel() {
        return fotoLabel;
    }

    /**
     * @param fotoLabel the fotoLabel to set
     */
    public void setFotoLabel(JLabel fotoLabel) {
        this.fotoLabel = fotoLabel;
    }

    /**
     * @return the fotoIcon
     */
    public ImageIcon getFotoIcon() {
        return fotoIcon;
    }

    /**
     * @param fotoIcon the fotoIcon to set
     */
    public void setFotoIcon(ImageIcon fotoIcon) {
        this.fotoIcon = fotoIcon;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}