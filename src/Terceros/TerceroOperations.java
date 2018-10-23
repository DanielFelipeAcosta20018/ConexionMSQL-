package Terceros;



public interface TerceroOperations 
{
  boolean insertarTercero (String nombre, String apellido, String telefono);
  boolean actualizarTercero (int id, String nombre, String apellido, String telefono);
  boolean eliminarTercero (int id);
  String consultarTercero (int id);
  void shoutdown ();
} // interface TerceroOperations
