package cl.accenture.curso_java.sistema_ventas.controlador;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import cl.accenture.curso_java.sistema_ventas.dao.ProductoDAO;
import cl.accenture.curso_java.sistema_ventas.dao.SucursalDAO;
import cl.accenture.curso_java.sistema_ventas.excepciones.SinConexionException;
import cl.accenture.curso_java.sistema_ventas.modelo.Producto;
import cl.accenture.curso_java.sistema_ventas.modelo.Sucursal;
import cl.accenture.curso_java.sistema_ventas.modelo.Usuario;

/**
 * @author Mauricio
 *
 */

@ManagedBean
@RequestScoped

public class ListarProductosControlador implements Serializable {

	private static final long serialVersionUID = -4669809923772737328L;
	private static final Logger LOGGER = Logger.getLogger(ListarProductosControlador.class);
	private List<Producto> productos;
	private List<Producto> productosSucursal;
	private String mensaje;
	

	public ListarProductosControlador() {
		this.productos = new ArrayList<Producto>();
	}

	

	/**
	 * @return the productos
	 */
	public List<Producto> getProductos() {
	



	/**
	 * @param productos the productos to set
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}




	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}



	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}




	/**
	 * @return the productosSucursal
	 */
	public List<Producto> getProductosSucursal() {
		return productosSucursal;
	}



	/**
	 * @param productosSucursal the productosSucursal to set
	 */
	public void setProductosSucursal(List<Producto> productosSucursal) {
		this.productosSucursal = productosSucursal;
	}




	public void obtenerProductosSucursal() {

		try {
			Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get("usuario");
			ProductoDAO dao = new ProductoDAO();
			this.setProductosSucursal(dao.obtenerProductosSucursal(user.getIdSucursal()));

		public List<Producto> getProductos() {
			return productos;

			

			this.setMensaje("");
			
		} catch (Exception e) {
			this.setMensaje("Ocurrio un error al obtener los productos.");
			this.setProductosSucursal(new ArrayList<Producto>());
			LOGGER.error("Error al obtener los productos por sucursal", e);

		}
		
	}

	public void ordenarPorIdProducto() {
		Collections.sort(this.productos, new Comparator<Producto>() {

			public int compare(Producto p1, Producto p2) {
				if (p1.getIdProducto() > p2.getIdProducto())
					return 1;
				if (p1.getIdProducto() < p2.getIdProducto())
					return -1;
				return 0;
			}

	public void ordenarPorNombre() {
		Collections.sort(this.productos, new Comparator<Producto>() {

			public int compare(Producto p1, Producto p2) {
				return p1.getNombre().toLowerCase().compareTo(p2.getNombre().toLowerCase());
			}

		});
	}

	public void ordenarPorCategoria() {
		Collections.sort(this.productos, new Comparator<Producto>() {

			public int compare(Producto p1, Producto p2) {
				return p1.getCategoria().toLowerCase().compareTo(p2.getCategoria().toLowerCase());
			}

		});
	}

	public void ordenarPorMarca() {
		Collections.sort(this.productos, new Comparator<Producto>() {

			public int compare(Producto p1, Producto p2) {
				return p1.getMarca().toLowerCase().compareTo(p2.getMarca().toLowerCase());
			}

		});
	}

	public void ordenarPorPrecio() {
		Collections.sort(this.productos, new Comparator<Producto>() {


		public void obtenerProductosSucursal(){
			List<Producto> productos = new ArrayList<Producto>();
			
			try{
				ProductoDAO dao = new ProductoDAO();
			productos =	dao.obtenerProductosSucursal(this.idSucursal);
				this.productos = productos;
				this.setMensaje("");
			}catch (Exception e) {
				this.setMensaje("Ocurrio un error al obtener los productos.");

			public int compare(Producto p1, Producto p2) {
				if (p1.getPrecio() > p2.getPrecio())
					return 1;
				if (p1.getPrecio() < p2.getPrecio())
					return -1;
				return 0;

			}

		});
	}

	public void ordenarPorStock() {
		Collections.sort(this.productos, new Comparator<Producto>() {

			public int compare(Producto p1, Producto p2) {
				if (p1.getStock() > p2.getStock())
					return 1;
				if (p1.getStock() < p2.getStock())
					return -1;
				return 0;
			}

		});

	}

}
