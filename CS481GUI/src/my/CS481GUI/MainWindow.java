package my.CS481GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jim
 */
public class MainWindow extends javax.swing.JFrame {


    public MainWindow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        containerPanel = new javax.swing.JPanel();
        controlPanel = new javax.swing.JPanel();
        bightnessSlider = new javax.swing.JSlider();
        contrastSlider = new javax.swing.JSlider();
        brightnessCheck = new javax.swing.JCheckBox();
        contrastCheck = new javax.swing.JCheckBox();
        cropCheck = new javax.swing.JCheckBox();
        labelCheck = new javax.swing.JCheckBox();
        autoEditButton = new javax.swing.JButton();
        ladderDropdown = new javax.swing.JComboBox();
        brightLabel = new javax.swing.JLabel();
        conLabel = new javax.swing.JLabel();
        geneSelLabel = new javax.swing.JLabel();
        autoOptionsLabel = new javax.swing.JLabel();
        manualOptionsLabel = new javax.swing.JLabel();
        cropButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        imagePanel = new ImagePanel();
        buttonPanel = new javax.swing.JPanel();
        openButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        undoButton = new javax.swing.JButton();

        this.setBackground(Color.white);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LadderLabel 1.0c");
        
        controlPanel.setOpaque(true);
        controlPanel.setBackground(Color.white);
        
        imagePanel.setOpaque(true);
        imagePanel.setBackground(Color.white);
        
        buttonPanel.setOpaque(true);
        buttonPanel.setBackground(Color.white);
        
        containerPanel.setOpaque(true);
        containerPanel.setBackground(Color.white);
        containerPanel.setPreferredSize(new java.awt.Dimension(900, 724));

        brightnessCheck.setText(" Brightness");

        contrastCheck.setText(" Contrast");

        cropCheck.setText(" Cropping");

        labelCheck.setText(" Label");

        autoEditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/CS481GUI/Edit.png"))); // NOI18N
        autoEditButton.setText("Auto Edit");

        ladderDropdown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "           --   Must Select!   --", "GeneRuler 1 kb DNA Ladder" }));
        ladderDropdown.setMinimumSize(new java.awt.Dimension(200, 20));
        ladderDropdown.setPreferredSize(new java.awt.Dimension(200, 20));

        brightLabel.setText("Brightness");

        conLabel.setText("Contrast");

        geneSelLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        geneSelLabel.setText("Gene Ladder Selection");

        autoOptionsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        autoOptionsLabel.setText("Auto Edit Options");

        manualOptionsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        manualOptionsLabel.setText("Manual Edit Options");

        cropButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/CS481GUI/Crop.png"))); // NOI18N
        cropButton.setText("Crop Image");
        
        //CROP BUTTON ACTION LISTENER!!
        cropButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cropButtonActionPerformed(evt);
            }
        });
        
        //AutoEdit Button Action Listener
        autoEditButton.addActionListener(new java.awt.event.ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt) {
        		autoEditButtonActionPerformed(evt);
        	}
        });
        
        //SaveButton Listener!
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(ladderDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brightLabel)
                    .addComponent(conLabel)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(geneSelLabel)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(autoOptionsLabel)
                    .addComponent(manualOptionsLabel)
                    .addComponent(cropButton)
                    .addComponent(bightnessSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(contrastSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(brightnessCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contrastCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cropCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(autoEditButton))
                .addGap(46, 46, 46))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(geneSelLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ladderDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manualOptionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(brightLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bightnessSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(conLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contrastSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cropButton)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(autoOptionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(brightnessCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contrastCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cropCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(autoEditButton)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        openButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/CS481GUI/open.gif"))); // NOI18N
        openButton.setText("Open");
        openButton.setToolTipText("Open Image (cntrl+O");
        openButton.setEnabled(true);

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/CS481GUI/Save.png"))); // NOI18N
        saveButton.setText("Save");
        saveButton.setToolTipText("Save (cntrl+S)");

        undoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/CS481GUI/Undo.png"))); // NOI18N
        undoButton.setText("Undo");
        undoButton.setToolTipText("Undo (cntrl+Z)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(openButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(undoButton)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openButton)
                    .addComponent(saveButton)
                    .addComponent(undoButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(containerPanel);
        containerPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(containerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1077, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(containerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }
    
    
    //CROP BUTTON ACTION LISTENER!!
    private void cropButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
		if (checkLadder()) {
			if (tips) {
				createTipsWindow("Click and drag on image to \n crop.");
			}
			// FILL IN WITH CROP FUNCTIONALITY

			imagePanel.runCrop();
		}
    }
    
    //Save Button Functionality!! YAY
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	JFileChooser c = new JFileChooser();
    	int rVal = c.showSaveDialog(this);
    	if (rVal == JFileChooser.APPROVE_OPTION){
    		filename = c.getSelectedFile().getName();
    		dir = c.getCurrentDirectory().toString();
    		String output = (dir + "\\" + filename + ".png");
    		File out = new File(output);
    		try {
				ImageIO.write(imagePanel.getImage(), "png", out);
			} catch (IOException e) {
				e.printStackTrace();
			}
    		
    	}
    }
    
    private void autoEditButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (checkLadder()) {
			if (tips) {
				createTipsWindow("The four checkboxes change\n which aspects of the image\n are auto-corrected.");
			}
			// FILL IN WITH AUTOEDIT FUNCTIONALITY
			System.out.println("Autoedit hit.");
		}
    }
    
    private void openButtonActionPerformed(java.awt.event.ActionEvent evt){
    	JFileChooser c = new JFileChooser();
    	int rVal = c.showOpenDialog(this);
    	if (rVal == JFileChooser.APPROVE_OPTION){
    		String open = "";
    		//open += c.getCurrentDirectory();
    		//open += "\\";
    		open += c.getSelectedFile();
    		System.out.println(open);
    		imagePanel.setImage(open);
    	}
    	
    }
    
    public boolean checkLadder(){
    	if (ladderDropdown.getSelectedIndex() == 0){
    		JOptionPane.showMessageDialog(this, "We recommend that you select your gene ladder before continuing.");
    		return false;
    	}
		return true;
    }
    
    public void createTipsWindow(String in){
    	JCheckBox tipCheck = new JCheckBox("Check to turn off tips");
    	JLabel spacer = new JLabel("\n");
    	JLabel spacer2 = new JLabel("\n");
    	Object[] params = {in, spacer, spacer2, tipCheck};
    	JOptionPane.showMessageDialog(this, params, "Tip", JOptionPane.OK_OPTION);
    	tips = !tipCheck.isSelected();
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton autoEditButton;
    private javax.swing.JButton openButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton undoButton;
    private javax.swing.JButton cropButton;
    private javax.swing.JCheckBox brightnessCheck;
    private javax.swing.JCheckBox contrastCheck;
    private javax.swing.JCheckBox cropCheck;
    private javax.swing.JCheckBox labelCheck;
    private javax.swing.JComboBox ladderDropdown;
    private javax.swing.JLabel brightLabel;
    private javax.swing.JLabel conLabel;
    private javax.swing.JLabel geneSelLabel;
    private javax.swing.JLabel autoOptionsLabel;
    private javax.swing.JLabel manualOptionsLabel;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JPanel buttonPanel;
    private ImagePanel imagePanel;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSlider bightnessSlider;
    private javax.swing.JSlider contrastSlider;
    static boolean tips = true;
    String filename = "";
    String dir = "";
    // End of variables declaration
}
