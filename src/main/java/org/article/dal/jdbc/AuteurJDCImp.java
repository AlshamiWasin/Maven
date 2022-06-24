package org.article.dal.jdbc;

import java.sql.*;

import org.article.bo.Auteur;
import org.article.bo.CartePostale;
import org.article.dal.DAO;
import org.article.dal.DalException;
import java.util.ArrayList;
import java.util.List;

public class AuteurJDCImp implements DAO<Auteur> {

    private static final String SQL_INSERT="insert into auteur ( prenomAuteur ,nomAuteur ) values(?,?)";
    private static final String SQL_UPDATE="update auteur set prenomAuteur=?,nomAuteur=? where idAuteur=?";
    private static final String SQL_DELETE="delete from auteur where  idAuteur=?";
    private static final String SQL_SELECT_ALL="select * from auteur";


    private static final String SQL_SELECT_ALL_CARTE_AUTEUR_BY_ID="select refProd from carte_auteur where idAuteur = ?";
    private static final String SQL_SELECT_BY_ID="select * from auteur where idAuteur=?";


    @Override
    public void insert(Auteur data) throws DalException {
        PreparedStatement pstmt=null;
        Connection cnx=JdbcTools.getConenction();
        try {
            pstmt=cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, data.getPrenom());
            pstmt.setString(2, data.getNom());

            int nbRow=pstmt.executeUpdate();
            if (nbRow==1)
            {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next())
                {
                    data.setId(rs.getLong(1));
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new DalException("erreur du insert - data="+data,e.getCause());
        }
        finally
        {
            try {
                if(pstmt!=null)
                {
                    pstmt.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                throw new DalException("erreur du insert au niveau du close- data="+data,e.getCause());
            }
        }

    }

    @Override
    public void delete(Auteur data) throws DalException {
        PreparedStatement pstmt=null;
        long id=data.getId();
        Connection cnx=JdbcTools.getConenction();
        try {
            pstmt=cnx.prepareStatement(SQL_DELETE);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new DalException("erreur du delete - data="+data,e.getCause());
        }
        finally
        {
            try {
                if(pstmt!=null)
                {
                    pstmt.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                throw new DalException("erreur du delete au niveau du close- data="+data,e.getCause());
            }
        }
    }

    @Override
    public void update(Auteur data) throws DalException {
        PreparedStatement pstmt=null;
        //Connection cnx=null;
        long id=data.getId();
        Connection cnx=JdbcTools.getConenction();
        try {
            pstmt=cnx.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, data.getPrenom());
            pstmt.setString(2, data.getNom());
            pstmt.setLong(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new DalException("erreur du update - data="+data,e.getCause());
        }
        finally
        {
            try {
                if(pstmt!=null)
                {
                    pstmt.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                throw new DalException("erreur du update au niveau du close- data="+data,e.getCause());
            }
        }
    }

    @Override
    public Auteur selectById(long id) throws DalException {
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Auteur auteur=null;
        //Connection cnx=null;
        Connection cnx=JdbcTools.getConenction();

        //Statement pour récupérer les Carte liée avec l'auteur
        PreparedStatement AuteurPstmt=null;
        ResultSet AuteurRs=null;
        try {
            pstmt=cnx.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setLong(1, id);
            rs=pstmt.executeQuery();

            ProduitJDCImp produitJDCImp = new ProduitJDCImp();
            List<CartePostale> listCarte = new ArrayList<>();
            if(rs.next())
            {

                AuteurPstmt=cnx.prepareStatement(SQL_SELECT_ALL_CARTE_AUTEUR_BY_ID);
                AuteurPstmt.setLong(1,rs.getLong(1));
                AuteurRs=AuteurPstmt.executeQuery();

               if (AuteurRs.next()){
                    listCarte.add((CartePostale) produitJDCImp.selectById( AuteurRs.getLong(1)));
                }
                auteur =new Auteur(rs.getLong(1),rs.getString(2),rs.getString(3) ,listCarte);
            }

        } catch (SQLException e) {
            throw  new RuntimeException(e);
            // TODO Auto-generated catch block
            /*throw new DalException("erreur du select by id - id="+id,e.getCause());*/
        }
        finally
        {
            try {
                if(pstmt!=null)
                {
                    pstmt.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                throw new DalException("erreur du select by id au niveau du close- id="+id,e.getCause());
            }
        }
        return auteur;
    }

    @Override
    public List<Auteur> selectAll() throws DalException {
        Statement stmt=null;
        ResultSet rs=null;
        List<Auteur> lesAuteurs= new ArrayList<>();

        PreparedStatement AuteurPstmt=null;
        ResultSet AuteurRs=null;

        Auteur auteur=null;
        Connection cnx=JdbcTools.getConenction();
        try {
            ProduitJDCImp produitJDCImp = new ProduitJDCImp();
            List<CartePostale> listCarte = new ArrayList<>();
            stmt=cnx.createStatement();
            rs=stmt.executeQuery(SQL_SELECT_ALL);
            while(rs.next())
            {
                AuteurPstmt=cnx.prepareStatement(SQL_SELECT_ALL_CARTE_AUTEUR_BY_ID);
                AuteurPstmt.setLong(1,rs.getLong(1));
                AuteurRs=AuteurPstmt.executeQuery();
                if (AuteurRs.next()){
                    listCarte.add((CartePostale) produitJDCImp.selectById( AuteurRs.getLong(1)));
                }

                auteur =new Auteur(rs.getLong(1),rs.getString(2),rs.getString(3),(List<CartePostale>) listCarte);
                lesAuteurs.add(auteur);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
            /*throw new DalException("erreur du select all",e.getCause());*/
        }
        finally
        {
            try {
                if(stmt!=null)
                {
                    stmt.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                throw new RuntimeException(e);
                /*throw new DalException("erreur du select all au niveau du close- ",e.getCause());*/
            }
        }
        return lesAuteurs;
    }
}
