import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InventoryGUI extends JFrame {

    private InventoryService service =
            new InventoryService();

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtQuantity;
    private JTextField txtPrice;

    private DefaultTableModel model;
    private JTable table;

    public InventoryGUI() {

        setTitle("Inventory Management System");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Product ID"));
        txtId = new JTextField();
        inputPanel.add(txtId);

        inputPanel.add(new JLabel("Product Name"));
        txtName = new JTextField();
        inputPanel.add(txtName);

        inputPanel.add(new JLabel("Quantity"));
        txtQuantity = new JTextField();
        inputPanel.add(txtQuantity);

        inputPanel.add(new JLabel("Price"));
        txtPrice = new JTextField();
        inputPanel.add(txtPrice);

        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();

        JButton btnAdd = new JButton("Add");
        JButton btnSearch = new JButton("Search");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnSearch);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);

        add(buttonPanel, BorderLayout.CENTER);

        model = new DefaultTableModel(
                new String[]{
                        "ID",
                        "Name",
                        "Quantity",
                        "Price"
                }, 0);

        table = new JTable(model);

        add(new JScrollPane(table),
                BorderLayout.SOUTH);

        btnAdd.addActionListener(
                e -> addProduct());

        btnSearch.addActionListener(
                e -> searchProduct());

        btnUpdate.addActionListener(
                e -> updateProduct());

        btnDelete.addActionListener(
                e -> deleteProduct());

        setVisible(true);
    }

    private void addProduct() {
        try {
            int id =
                    Integer.parseInt(
                            txtId.getText());

            String name =
                    txtName.getText();

            int quantity =
                    Integer.parseInt(
                            txtQuantity.getText());

            double price =
                    Double.parseDouble(
                            txtPrice.getText());

            Product p =
                    new Product(
                            id,
                            name,
                            quantity,
                            price);

            service.addProduct(p);

            refreshTable();
            clearFields();
        } catch (Exception e) {
    JOptionPane.showMessageDialog(
            this,
            e.getMessage());
}
    }

    private void searchProduct() {

        try {
            int id =
                    Integer.parseInt(
                            txtId.getText());

            Product p =
                    service.searchProduct(id);

            if (p == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "Product Not Found");
                return;
            }

            txtName.setText(
                    p.getName());

            txtQuantity.setText(
                    String.valueOf(
                            p.getQuantity()));

            txtPrice.setText(
                    String.valueOf(
                            p.getPrice()));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Input");
        }
    }

    private void updateProduct() {

        try {
            int id =
                    Integer.parseInt(
                            txtId.getText());

            int quantity =
                    Integer.parseInt(
                            txtQuantity.getText());

            double price =
                    Double.parseDouble(
                            txtPrice.getText());

            service.updateProduct(
                    id,
                    quantity,
                    price);

            refreshTable();
            clearFields();

        }catch (Exception e) {
    JOptionPane.showMessageDialog(
            this,
            e.getMessage());
}
    }

    private void deleteProduct() {

        try {
            int id =
                    Integer.parseInt(
                            txtId.getText());

            service.deleteProduct(id);

            refreshTable();
            clearFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Input");
        }
    }

    private void refreshTable() {

        model.setRowCount(0);

        for (Product p :
                service.getInventory().values()) {

            model.addRow(
                    new Object[]{
                            p.getId(),
                            p.getName(),
                            p.getQuantity(),
                            p.getPrice()
                    });
        }
    }

    private void clearFields() {

        txtId.setText("");
        txtName.setText("");
        txtQuantity.setText("");
        txtPrice.setText("");
    }
}