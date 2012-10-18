String query = "INSERT INTO divisions (id,name,abbr,meet_id) VALUES (?,?,?,?)";
PreparedStatement pstmt = conn.prepareStatement(query);

for(int i=1; i<table.length; i++)
{       
  String[] data = table[i].split(";");

  pstmt.setInt(1, Integer.parseInt(data[map.get("Div_no")]));
  pstmt.setString(2, data[map.get("Div_name")]);
  pstmt.setString(3, data[map.get("Div_abbr")]);
  pstmt.setInt(4, meetID);
  pstmt.addBatch();
}

Statement stmt = conn.createStatement();
      stmt.executeUpdate("DELETE FROM divisions WHERE meet_id='"+meetID+"';");
      stmt.close();
      
      pstmt.executeBatch();
pstmt.close();