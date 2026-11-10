public class Cliente extends Usuario {
    public Cliente(int idUsuario, String username, String passwordHash, String salt, String nombreCompleto) {
        super(idUsuario, username, passwordHash, salt, nombreCompleto, Rol.CLIENTE);
    }

    @Override
    public boolean esAdministrador() {
        return false;
    }
}