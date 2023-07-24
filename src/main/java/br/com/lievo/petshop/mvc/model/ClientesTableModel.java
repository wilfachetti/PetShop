package br.com.lievo.petshop.mvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ClientesTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private static final int COL_ID = 0;
	private static final int COL_NOME = 1;
	private static final int COL_TELEFONE = 2;
	private static final int COL_EMAIL = 3;
	private List<ClienteModel> linhas;
	private String[] colunas = new String[]{"<html><b>Id</b></html>", "<html><b>Nome</b></html>", "<html><b>Celular</b></html>", "<html><b>e-mail</b></html>"};

	public ClientesTableModel(List<ClienteModel> clientes) {
		this.linhas = new ArrayList<>(clientes);
	}

	public int getRowCount() {
		return linhas.size();
	}

	public int getColumnCount() {
		return colunas.length;
	}

	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}

	public Class getColumnClass(int columnIndex) {
		if (columnIndex == COL_ID) {
			return Integer.class;
		}
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int	columnIndex) {
		return false;
	}

	public Object getValueAt(int row, int column) {
		ClienteModel m = linhas.get(row);

		if (column == COL_ID) {
			return m.getId();
		} else if (column == COL_NOME) {
			return m.getNome();
		} else if (column == COL_TELEFONE) {
			return m.getTelefone();
		} else if (column == COL_EMAIL) {
			return m.getEmail();
		}
		return "";
	}

	public void setValueAt(Object aValue, int row, int column) {
		ClienteModel u = linhas.get(row);
		if (column == COL_ID) {
			u.setId((Long) aValue);
		} else if (column == COL_NOME) {
			u.setNome(aValue.toString());
		} else if (column == COL_TELEFONE) {
			u.setTelefone(aValue.toString());
		} else if (column == COL_EMAIL) {
			u.setEmail(aValue.toString());
		}
	}

	public ClienteModel getCliente(int indiceLinha) {
		return linhas.get(indiceLinha);
	}

	public void addClicente(ClienteModel cliente) {
		linhas.add(cliente);
		int ultimoIndice = getRowCount() - 1;
		fireTableRowsInserted(ultimoIndice,	ultimoIndice);
	}

	public void updateCliente(int indiceLinha, ClienteModel marca) {
		linhas.set(indiceLinha, marca);
		fireTableRowsUpdated(indiceLinha, indiceLinha);
	}

	public void removeClicente(int indiceLinha) {
		linhas.remove(indiceLinha);
		fireTableRowsDeleted(indiceLinha, indiceLinha);
	}
}