using System;
using System.Windows.Forms;

namespace ClienteOperaciones
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void btnCalcular_Click(object sender, EventArgs e)
        {
            try
            {
                int a = int.Parse(txtA.Text);
                int b = int.Parse(txtB.Text);
                using (var client = new Operaciones.ClienteOperaciones())
                {
                    int resultado = client.Sumar(a, b);
                    lblRespuesta.Text = $"Suma: {resultado}";
                }
            }
            catch (FormatException)
            {
                MessageBox.Show("Ingrese números enteros.");
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error: " + ex.Message);
            }
        }
    }
}