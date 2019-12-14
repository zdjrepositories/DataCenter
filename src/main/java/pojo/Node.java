package pojo;

public class Node {
    private Long oid;
    private Long parent_oid;
    private String name;
    private String description;
    private short has_Configurable;
    private short has_Document;
    private short has_Product;
    private short has_RichText;
    private short visible;
    private String commercial_References;
    private String sub_Nodes;

    @Override
    public String toString() {
        return "Node{" +
                "oid=" + oid +
                ", parent_oid=" + parent_oid +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", has_Configurable=" + has_Configurable +
                ", has_Document=" + has_Document +
                ", has_Product=" + has_Product +
                ", has_RichText=" + has_RichText +
                ", visible=" + visible +
                ", commercial_References='" + commercial_References + '\'' +
                ", sub_Nodes='" + sub_Nodes + '\'' +
                '}';
    }

    public Long getOid() {
        return oid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getHas_Configurable() {
        return has_Configurable;
    }

    public void setHas_Configurable(short has_Configurable) {
        this.has_Configurable = has_Configurable;
    }

    public void setHas_Configurable(boolean has_Configurable) {
        this.has_Configurable = has_Configurable ? (short) 1 : 0;
    }

    public short getHas_Document() {
        return has_Document;
    }

    public void setHas_Document(short has_Document) {
        this.has_Document = has_Document;
    }

    public void setHas_Document(boolean has_Document) {
        this.has_Configurable = has_Document ? (short) 1 : 0;
    }

    public short getHas_Product() {
        return has_Product;
    }

    public void setHas_Product(short has_Product) {
        this.has_Product = has_Product;
    }

    public void setHas_Product(boolean has_Product) {
        this.has_Configurable = has_Product ? (short) 1 : 0;
    }

    public short getHas_RichText() {
        return has_RichText;
    }

    public void setHas_RichText(short has_RichText) {
        this.has_RichText = has_RichText;
    }

    public void setHas_RichText(boolean has_RichText) {
        this.has_Configurable = has_RichText ? (short) 1 : 0;
    }

    public short getVisible() {
        return visible;
    }

    public void setVisible(short visible) {
        this.visible = visible;
    }

    public void setVisible(boolean visible) {
        this.has_Configurable = visible ? (short) 1 : 0;
    }

    public String getCommercial_References() {
        return commercial_References;
    }

    public void setCommercial_References(String commercial_References) {
        this.commercial_References = commercial_References;
    }

    public String getSub_Nodes() {
        return sub_Nodes;
    }

    public void setSub_Nodes(String sub_Nodes) {
        this.sub_Nodes = sub_Nodes;
    }


    public Long getParent_oid(Long oid) {
        return parent_oid;
    }

    public Long getParent_oid() {
        return parent_oid;
    }

    public void setParent_oid(Long parent_oid) {
        this.parent_oid = parent_oid;
    }


}