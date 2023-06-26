import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class TelaUsuario extends JPanel {
    private JLabel nameLabel, ageLabel, emailLabel, weightLabel, heightLabel, generoLabel;
    private JTextField nameField, ageField, emailField, weightField, heightField, generoField;
    private JButton editButton; 
    private JTabbedPane tabbedPane;
    private JLabel photoLabel;
    private ImageIcon photoIcon;

    public TelaUsuario() {
        //setTitle("Página do Usuário");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(400, 400);
        //setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        tabbedPane = new JTabbedPane();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        photoLabel = new JLabel();
        photoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        photoLabel.setVerticalAlignment(SwingConstants.CENTER);
        mainPanel.add(photoLabel, BorderLayout.NORTH);
        
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2));

        nameLabel = new JLabel("Nome:");
        //nameField = new JTextField();
        ageLabel = new JLabel("Idade:");
        //ageField = new JTextField();
        generoLabel = new JLabel("Gênero:");
        //generoField = new JTextField();
        weightLabel = new JLabel("Peso (Kg):");
        //weightField = new JTextField();
        heightLabel = new JLabel("Altura (cm):");
        //heightField = new JTextField();
        emailLabel = new JLabel("Email:");
        //emailField = new JTextField();

        formPanel.add(nameLabel);
        //formPanel.add(nameField);
        formPanel.add(ageLabel);
        //formPanel.add(ageField);
        formPanel.add(generoLabel);
        //formPanel.add(generoField);
        formPanel.add(emailLabel);
        //formPanel.add(emailField);
        formPanel.add(weightLabel);
        //formPanel.add(weightField);
        formPanel.add(heightLabel);
        //formPanel.add(heightField);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        tabbedPane.addTab("Informações do Usuário", mainPanel);
        add(tabbedPane, BorderLayout.CENTER);

        editButton = new JButton("Editar");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel editPanel = new JPanel();
                editPanel.setLayout(new BorderLayout());

                JLabel editPhotoLabel = new JLabel();
                editPhotoLabel.setHorizontalAlignment(SwingConstants.CENTER);
                editPhotoLabel.setVerticalAlignment(SwingConstants.CENTER);
                editPanel.add(editPhotoLabel, BorderLayout.NORTH);

                JLabel editNameLabel = new JLabel("Nome:");
                JTextField editNameField = new JTextField();
                JLabel editAgeLabel = new JLabel("Idade:");
                JTextField editAgeField = new JTextField();
                JLabel editGeneroLabel = new JLabel("Gênero:");
                JTextField editGeneroField = new JTextField();
                JLabel editWeightLabel = new JLabel("Peso (Kg):");
                JTextField editWeightField = new JTextField();
                JLabel editHeightLabel = new JLabel("Altura (cm):");
                JTextField editHeightField = new JTextField();
                JLabel editEmailLabel = new JLabel("Email:");
                JTextField editEmailField = new JTextField();

                JPanel editFieldsPanel = new JPanel();
                editFieldsPanel.setLayout(new GridLayout(6, 2));
                editFieldsPanel.add(editNameLabel);
                editFieldsPanel.add(editNameField);
                editFieldsPanel.add(editAgeLabel);
                editFieldsPanel.add(editAgeField);
                editFieldsPanel.add(editGeneroLabel);
                editFieldsPanel.add(editGeneroField);
                editFieldsPanel.add(editWeightLabel);
                editFieldsPanel.add(editWeightField);
                editFieldsPanel.add(editHeightLabel);
                editFieldsPanel.add(editHeightField);
                editFieldsPanel.add(editEmailLabel);
                editFieldsPanel.add(editEmailField);

                editPanel.add(editFieldsPanel, BorderLayout.CENTER);

                JButton cancelButton = new JButton("Cancelar");
                cancelButton.addActionListener(new ActionListener () {
                    public void actionPerformed(ActionEvent e) {
                        tabbedPane.remove(editPanel);
                    }
                });

                JButton photoButton = new JButton("Selecione uma foto");
                JFileChooser fileChooser = new JFileChooser();
                photoButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
                        fileChooser.setFileFilter(filter);

                        int result = fileChooser.showOpenDialog(null);
                        if (result == JFileChooser.APPROVE_OPTION) {
                            File selectedPhoto = fileChooser.getSelectedFile();
                            ImageIcon imageIcon = new ImageIcon(selectedPhoto.getPath());
                            editPhotoLabel.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
                        }
                    }
                });

                JButton saveButton = new JButton("Salvar");
                saveButton.addActionListener(new ActionListener () {
                    public void actionPerformed(ActionEvent e) {
                        String editedName = editNameField.getText();
                        String editedAge = editAgeField.getText();
                        String editedEmail = editEmailField.getText();
                        String editedWeight = editWeightField.getText();
                        String editedHeight = editHeightField.getText();
                        String editedGenero = editGeneroField.getText();
                        // if (editedName.isEmpty()) {
                        //     editedName = nameField.getText();
                        // }
                        // if (editedAge.isEmpty()) {
                        //     editedAge = ageField.getText();
                        // }
                        // if (editedEmail.isEmpty()) {
                        //     editedEmail = emailField.getText();
                        // }
                        // if (editedWeight.isEmpty()) {
                        //     editedWeight = weightField.getText();
                        // }
                        // if (editedHeight.isEmpty()) {
                        //     editedHeight = heightField.getText();
                        // }
                        // if (editedGenero.isEmpty()) {
                        //  editedGenero = generoField.getText();   
                        // }
                        
                        // nameField.setText(editedName);
                        // ageField.setText(editedAge);
                        // emailField.setText(editedEmail);
                        // weightField.setText(editedWeight);
                        // heightField.setText(editedHeight);
                        // generoField.setText(editedGenero);

                        File editedPhotoFile = fileChooser.getSelectedFile();
                        if (editedPhotoFile != null) {
                            photoIcon = new ImageIcon(editedPhotoFile.getPath());
                            photoLabel.setIcon(new ImageIcon(photoIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
                        }

                        tabbedPane.remove(editPanel);
                    }
                });

                JPanel editButtonsPanel = new JPanel();
                editButtonsPanel.add(cancelButton);
                editButtonsPanel.add(saveButton);
                editButtonsPanel.add(photoButton);

                editPanel.add(editButtonsPanel, BorderLayout.SOUTH);

                tabbedPane.addTab("", editPanel);
                tabbedPane.setSelectedComponent(editPanel);
            }
        });

        add(editButton, BorderLayout.SOUTH);
        setVisible(true);
    }
}