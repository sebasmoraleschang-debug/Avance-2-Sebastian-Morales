public class Administrador extends Usuario {
    public Administrador(int idUsuario, String username, String passwordHash, String salt, String nombreCompleto) {
        super(idUsuario, username, passwordHash, salt, nombreCompleto, Rol.ADMINISTRADOR);
    }

    @Override
    public boolean esAdministrador() {
        return true;
    }
}