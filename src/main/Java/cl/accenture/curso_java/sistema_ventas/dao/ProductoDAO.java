/**
 * 
 */
package cl.accenture.curso_java.sistema_ventas.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.accenture.curso_java.sistema_ventas.excepciones.SinConexionException;
import cl.accenture.curso_java.sistema_ventas.modelo.Conexion;
import cl.accenture.curso_java.sistema_ventas.modelo.Producto;

/**
 * @author Martin Cuevas
 *
 */
public class ProductoDAO {
	private Conexion conexion;
	private List<Producto> productos;

	/**
	 * 
	 */
	public ProductoDAO() {
		this.conexion = new Conexion();
		this.productos = new ArrayList<Producto>();
	}

	/**
	 * @param conexion
	 * @param productos
	 */
	public ProductoDAO(Conexion conexion, List<Producto> productos) {
		this.conexion = conexion;
		this.productos = productos;
	}

	/**
	 * @return the conexion
	 */
	public Conexion getConexion() {
		return conexion;
	}

	/**
	 * @param conexion
	 *            the conexion to set
	 */
	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

	/**
	 * @return the productos
	 */
	public List<Producto> getProductos() {
		return productos;
	}

	/**
	 * @param productos
	 *            the productos to set
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public void guardarProductos(List<Producto> productos) throws SQLException, SinConexionException {
		Connection conec = conexion.obtenerConexion();
		for (Producto producto : productos) {
			PreparedStatement psInsert = conec.prepareStatement("INSERT INTO producto(idProducto, nombre, precio, marca, stock, categoria, minstock, sucursal_idSucursal)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
			
			psInsert.setInt(1, producto.getIdProducto());
			psInsert.setString(2, producto.getNombre());
			psInsert.setInt(3, producto.getPrecio());
			psInsert.setString(4, producto.getMarca());
			psInsert.setInt(5, producto.getStock());
			psInsert.setString(6, producto.getCategoria());
			psInsert.setInt(7, producto.getMinstock());
			psInsert.setInt(8, producto.getSucursal_idSucursal());
			
			psInsert.executeUpdate();
		}
		
	}

}