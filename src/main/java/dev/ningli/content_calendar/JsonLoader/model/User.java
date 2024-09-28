package dev.ningli.content_calendar.JsonLoader.model;
public record User(int id,
                   String name,
                   String username,
                   String email,
                   Address address,
                   String phone,
                   String website,
                   Company company) {
    @Override
    public String toString() {
        return "User {" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}';
    }
}
