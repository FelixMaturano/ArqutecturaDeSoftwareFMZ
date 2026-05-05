using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;// Es la que nos permite crear aplicaciones de escritorio con ventanas, botones, etc.

// El namespace es el contenedor de nuestro código, y el nombre del proyecto es ClienteCotizaciones
namespace ClienteCotizaciones
{
    //Hay una clase llamada Form1 que hereda de Form, lo que significa que esta clase representa una ventana en la aplicación de escritorio.
    public partial class Form1 : Form
    {
        // El constructor de la clase Form1, que se llama cuando se crea una instancia de esta clase. Aquí se inicializan los componentes de la interfaz gráfica.
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void btnObtener_Click(object sender, EventArgs e)
        {
            try
            {
                // 1. Instanciamos el cliente usando el nombre de la referencia que creaste
                var cliente = new ReferenciaCotizaciones.ServicioCotizacionSoapClient();

                // 2. Obtenemos la fecha de la caja de texto
                string fecha = txtFecha.Text;

                // 3. Llamamos al servicio web
                string respuesta = cliente.obtenerCotizacion(fecha);

                // 4. Mostramos el resultado
                lblResultado.Text = respuesta;
            }
            catch (Exception ex)
            {
                lblResultado.Text = "Error: " + ex.Message;
            }

        }
        // Este método se ejecuta cuando se hace clic en el botón "Registrar". Intenta registrar una nueva cotización usando el servicio web y muestra el resultado o un mensaje de error.
        private void btnRegistrar_Click(object sender, EventArgs e)
        {
            try
            {
                // Instanciamos el cliente usando el nombre de la referencia que creaste
                var cliente = new ReferenciaCotizaciones.ServicioCotizacionSoapClient();
                // Obtenemos la fecha y el monto de las cajas de texto
                string fecha = txtFecha.Text;
                // Convertimos el texto ingresado a un número decimal
                decimal monto = decimal.Parse(txtMonto.Text);

                // Llamamos al método de registrar
                string respuesta = cliente.registrarCotizacion(fecha, monto);
                // Mostramos el resultado
                lblResultado.Text = respuesta;
            }
            catch (FormatException)
            {
                lblResultado.Text = "Por favor, ingresa un número válido en la casilla de Monto.";
            }
            catch (Exception ex)
            {
                lblResultado.Text = "Error: " + ex.Message;
            }
        }
    }
}
