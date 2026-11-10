public abstract class Usuario {
    protected int idUsuario;
    protected String username;
    protected String passwordHash;
    protected String salt;
    protected String nombreCompleto;
    protected Rol rol;

    public Usuario(int idUsuario, String username, String passwordHash, String salt, String nombreCompleto, Rol rol) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.passwordHash = passwordHash;
        this.salt = salt;
        this.nombreCompleto = nombreCompleto;
        this.rol = rol;
    }

    public boolean validarCredenciales(String clave) {
        return this.passwordHash.equals(clave);
    }

    public void cambiarClave(String nueva) {
        this.passwordHash = nueva;
    }

    public abstract boolean esAdministrador();
    
    public String getUsername() { return username; }
}