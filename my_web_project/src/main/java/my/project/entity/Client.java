package my.project.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private BigInteger clientId;

    @Column(name = "client_name")
    private String nameClient;

    @Column(name = "client_project")
    private String nameProject;

    @Column(name = "client_address")
    private String address;

    public Client() {
    }

    public Client(String nameClient, String nameProject, String address) {
        this.nameClient = nameClient;
        this.nameProject = nameProject;
        this.address = address;
    }

    public Client(BigInteger clientId, String nameClient, String nameProject, String address) {
        this.clientId = clientId;
        this.nameClient = nameClient;
        this.nameProject = nameProject;
        this.address = address;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + clientId +
                ", nameClient='" + nameClient + '\'' +
                ", nameProject='" + nameProject + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientId.equals(client.clientId) && nameClient.equals(client.nameClient) && nameProject.equals(client.nameProject) && address.equals(client.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, nameClient, nameProject, address);
    }
}
