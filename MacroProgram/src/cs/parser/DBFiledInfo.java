package cs.parser;

public class DBFiledInfo {

	String tableName;
	String logicalName;
	String columnName;
	String name;
	String sizeName;
	String notNullName;
	String primaryKeyName;

	public void setTableName(String tableName) {
		this.tableName = tableName;

	}

	public String getTableName() {

		return tableName;
	}

	public String getlogcialName() {

		return logicalName;
	}

	public void setlogcialName(String logicalName) {
		this.logicalName = logicalName;
	}

	public String getcolumnName() {
		return columnName;
	}

	public void setcolumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getsizeName() {
		return sizeName;
	}

	public void setsizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public String getnotNullName() {
		return notNullName;
	}

	public void setnotNullName(String notNullName) {
		this.notNullName = notNullName;
	}

	public String getprimaryKeyName() {
		return primaryKeyName;
	}

	public void setprimaryKeyName(String primaryKeyName) {
		this.primaryKeyName = primaryKeyName;
	}

}
