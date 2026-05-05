namespace ClienteOperaciones
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            txtA = new TextBox();
            txtB = new TextBox();
            cbOperacion = new ComboBox();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            backgroundWorker1 = new System.ComponentModel.BackgroundWorker();
            btnCalcular = new Button();
            lblRespuesta = new Label();
            SuspendLayout();
            // 
            // txtA
            // 
            txtA.Location = new Point(313, 36);
            txtA.Name = "txtA";
            txtA.Size = new Size(125, 27);
            txtA.TabIndex = 0;
            txtA.TextChanged += textBox1_TextChanged;
            // 
            // txtB
            // 
            txtB.Location = new Point(313, 81);
            txtB.Name = "txtB";
            txtB.Size = new Size(125, 27);
            txtB.TabIndex = 1;
            txtB.TextChanged += textBox2_TextChanged;
            // 
            // cbOperacion
            // 
            cbOperacion.FormattingEnabled = true;
            cbOperacion.Items.AddRange(new object[] { "Suma", "Resta", "Multiplicacion", "Division" });
            cbOperacion.Location = new Point(313, 130);
            cbOperacion.Name = "cbOperacion";
            cbOperacion.Size = new Size(151, 28);
            cbOperacion.TabIndex = 2;
            cbOperacion.SelectedIndexChanged += comboBox1_SelectedIndexChanged;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(204, 39);
            label1.Name = "label1";
            label1.Size = new Size(78, 20);
            label1.TabIndex = 3;
            label1.Text = "Numero a:";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(216, 84);
            label2.Name = "label2";
            label2.Size = new Size(83, 20);
            label2.TabIndex = 4;
            label2.Text = "Numero b: ";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(216, 138);
            label3.Name = "label3";
            label3.Size = new Size(78, 20);
            label3.TabIndex = 5;
            label3.Text = "Operacion";
            // 
            // btnCalcular
            // 
            btnCalcular.Location = new Point(325, 164);
            btnCalcular.Name = "btnCalcular";
            btnCalcular.Size = new Size(94, 49);
            btnCalcular.TabIndex = 6;
            btnCalcular.Text = "Calcular";
            btnCalcular.UseVisualStyleBackColor = true;
            btnCalcular.Click += btnCalcular_Click;
            // 
            // lblRespuesta
            // 
            lblRespuesta.AutoSize = true;
            lblRespuesta.Location = new Point(204, 164);
            lblRespuesta.Name = "lblRespuesta";
            lblRespuesta.Size = new Size(0, 20);
            lblRespuesta.TabIndex = 7;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(lblRespuesta);
            Controls.Add(btnCalcular);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(cbOperacion);
            Controls.Add(txtB);
            Controls.Add(txtA);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox txtA;
        private TextBox txtB;
        private ComboBox cbOperacion;
        private Button btnCalcular;
        private Label label1;
        private Label label2;
        private Label label3;
        private System.ComponentModel.BackgroundWorker backgroundWorker1;
        private Label lblRespuesta;
    }
}
