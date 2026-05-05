using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;      // Es la que permite que todo funcione a traves de internet, (SOAP)
using MySql.Data.MySqlClient;// que tiene las herramientas para conectarnos a MySQL
using System.Configuration; // Que nos permite leer archivos de configuracion como web.config 

/// <summary>
/// Descripción breve de ServicioCotizacion
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
[System.ComponentModel.ToolboxItem(false)]
// Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
// [System.Web.Script.Services.ScriptService]
public class ServicioCotizacion : System.Web.Services.WebService
{
    // Leemos la cadena de conexión desde el archivo web.config usando ConfigurationManager
    private string cadenaConexion = ConfigurationManager.ConnectionStrings["MySqlConn"].ConnectionString;

    // El método WebMethod es el que se expone para ser llamado desde el cliente.
    [WebMethod(Description = "Obtiene la cotización actual segun una fecha especifica (formato: yyyy-MM-dd)")]
    
    public string obtenerCotizacion(string fecha)
    {
        //Crea la conexión a la base de datos usando la cadena de conexión leída del web.config. El bloque using asegura que la conexión se cierre correctamente después de usarla.
        using (MySqlConnection conn = new MySqlConnection(cadenaConexion))
        {
            try
            {
                // Abrimos la conexión a la base de datos
                conn.Open();
                // Consulta SQL para buscar la cotización
                string query = "SELECT cotizacion FROM cotizaciones WHERE fecha = @fecha";

                using (MySqlCommand cmd = new MySqlCommand(query, conn))
                {
                    // Pasamos el parámetro de forma segura para evitar inyecciones SQL
                    cmd.Parameters.AddWithValue("@fecha", fecha);

                    // ExecuteScalar trae la primera columna de la primera fila
                    object resultado = cmd.ExecuteScalar();

                    if (resultado != null)
                    {
                        return "La cotización para " + fecha + " es: " + resultado.ToString();
                    }
                    else
                    {
                        return "No se encontró ninguna cotización para la fecha " + fecha;
                    }
                }
            }
            catch (Exception ex)
            {
                return "Error en la base de datos: " + ex.Message;
            }
        }
    }

    [WebMethod(Description = "Registra una nueva cotización en la base de datos")]
    public string registrarCotizacion(string fecha, decimal monto)
    {
        using (MySqlConnection conn = new MySqlConnection(cadenaConexion))
        {
            try
            {
                conn.Open();
                // Como el documento pide registrar Fecha y Monto, asignamos '6.97' por defecto a cotizacion_oficial
                string query = "INSERT INTO cotizaciones (fecha, cotizacion, cotizacion_oficial) VALUES (@fecha, @monto, '6.97')";

                using (MySqlCommand cmd = new MySqlCommand(query, conn))
                {
                    cmd.Parameters.AddWithValue("@fecha", fecha);
                    cmd.Parameters.AddWithValue("@monto", monto);

                    // ExecuteNonQuery se usa para INSERT, UPDATE o DELETE. Devuelve las filas afectadas.
                    int filasAfectadas = cmd.ExecuteNonQuery();

                    if (filasAfectadas > 0)
                    {
                        return "Éxito: Cotización registrada correctamente.";
                    }
                    else
                    {
                        return "Error: No se pudo registrar.";
                    }
                }
            }
            catch (Exception ex)
            {
                // Si intentas registrar una fecha que ya existe, saltará este error por la regla UNIQUE de la tabla
                return "Ocurrió un error (¿Quizás la fecha ya está registrada?): " + ex.Message;
            }
        }
    }
}
/* Este archivo es el motor o el cerebro del servicio. Ws el que se 
 encarga de recibir las peticiones de la pantalla contectarase a MySQL para 
buscar o guardar los datos, y devolver los resultados. */