package org.article;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.article.bll.BLLException;
import org.article.bll.produitManager;
import org.article.bo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * JavaFX App
 */
public class App extends Application {

    VBox root = new VBox();

    VBox topBox = new VBox();

    private VBox produitInfo = new VBox();
    private HBox referenceBox = new HBox();
    Label Reference = new Label ("Reference :");
    private TextField ReferencetextField = new TextField();
    HBox LibelleBox = new HBox();
    Label Libelle = new Label ("Libelle :");
    TextField LibelletextField = new TextField();
    HBox MarqueBox = new HBox();
    Label Marque = new Label ("Marque :");
    TextField MarquetextField = new TextField();

    HBox PrixBox = new HBox();
    Label Prix = new Label ("Prix :");
    TextField PrixtextField = new TextField();

    HBox QuantiteBox = new HBox();
    Label Quantite = new Label ("Quantite :");
    TextField QuantitetextField = new TextField();


    HBox typeProduitBox = new HBox();
    Label typeProduit = new Label ("Type de Produit :");
    ChoiceBox typeProduitchoiceBox = new ChoiceBox<>();


    HBox PoidBox = new HBox();
    Label Poids = new Label ("Poids :");
    TextField PoidstextField = new TextField();

    HBox DateBox = new HBox();
    Label Date = new Label ("Date de premeption :");
    TextField DatetextField = new TextField();

    HBox CoulerBox = new HBox();
    Label Couler = new Label ("Couler :");
    TextField CoulertextField = new TextField();

    HBox TypeBox = new HBox();
    Label Type = new Label ("Type de mine :");
    TextField TypetextField = new TextField();


    HBox ParfumBox = new HBox();
    Label Parfum = new Label ("Poids :");
    TextField ParfumtextField = new TextField();


    HBox TempBox = new HBox();
    Label Temperature = new Label ("Temperature de conservation:");
    TextField TemptextField = new TextField();

    HBox buttomBox = new HBox();
    Button precedentButton = new Button("precedent");
    Button nouveauButton = new Button("nouveau");
    Button enregistrerButton = new Button("enregistrer");
    Button suprimerButton = new Button("suprimer");
    Button suivantButton = new Button("suivant");











    Produit produit;

    private produitManager monM= produitManager.getInstance();
    private List<Produit> produits = new ArrayList<>();
    private Integer produitNumber = 0;

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        root.setSpacing(10);
        topBox.setSpacing(10);
        referenceBox.setSpacing(10);
        LibelleBox.setSpacing(10);
        LibelleBox.getChildren().add(Libelle);
        LibelleBox.getChildren().add(LibelletextField);
        MarqueBox.setSpacing(10);
        MarqueBox.getChildren().add(Marque);
        MarqueBox.getChildren().add(MarquetextField);
        PrixBox.setSpacing(10);
        PrixBox.getChildren().add(Prix);
        PrixBox.getChildren().add(PrixtextField);
        QuantiteBox.setSpacing(10);
        QuantiteBox.getChildren().add(Quantite);
        QuantiteBox.getChildren().add(QuantitetextField);
        ReferencetextField.setDisable(true);
        referenceBox.getChildren().add(Reference);
        referenceBox.getChildren().add(ReferencetextField);



        menu();

        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();


        suivantButton.setOnAction(e -> {
            try {
                if (produitNumber < monM.getLesProduit().size() - 1) {
                    produitNumber++;
                    root.getChildren().clear();
                    menu();

                } else {
                    suivantButton.setDisable(true);
                }
            } catch (BLLException g) {
                throw new RuntimeException(g);
            }
        });
    }

    public void menu(){

        try {
            produits =monM.getLesProduit();
        } catch (BLLException e) {
            throw new RuntimeException(e);
        }

        produit = produits.get(produitNumber);


        ReferencetextField.setText( String.valueOf(produit.getRefProd()) );
        LibelletextField.setText(String.valueOf(produit.getLibelle()) );
        MarquetextField.setText(String.valueOf( produit.getMarque()));
        PrixtextField.setText( String.valueOf( produit.getPrixUnitaire()));
        QuantitetextField.setText(String.valueOf( produit.getQteStock()));







        typeProduitBox.setSpacing(10);
        if (produit instanceof Pain){
            typeProduitchoiceBox.setValue("pain");

            PoidstextField.setText(String.valueOf( ((Pain) produit).getPoids()));
            DatetextField.setText(String.valueOf( ((Pain) produit).getDatelimitConso()));


            PoidBox.setSpacing(10);
            
            PoidBox.getChildren().add(Poids);
            Poids.setVisible();
            PoidBox.getChildren().add(PoidstextField);

            DateBox.setSpacing(10);

            DateBox.getChildren().add(Date);
            DateBox.getChildren().add(DatetextField);

            topBox.getChildren().add(PoidBox);
            topBox.getChildren().add(DateBox);

        }else if (produit instanceof Stylo){
            typeProduitchoiceBox.setValue("stylo");


            CoulerBox.setSpacing(10);
            CoulertextField.setText(String.valueOf( ((Stylo) produit).getCouleur()));
            CoulerBox.getChildren().add(Couler);
            CoulerBox.getChildren().add(CoulertextField);



            TypeBox.setSpacing(10);
            TypetextField.setText(String.valueOf( ((Stylo) produit).getTypeMine()));
            TypeBox.getChildren().add(Type);
            TypeBox.getChildren().add(TypetextField);


        }else if (produit instanceof CartePostale){
            typeProduitchoiceBox.setValue("CartePostal");



        }else if (produit instanceof Glace){
            typeProduitchoiceBox.setValue("glace");




            ParfumBox.setSpacing(10);
            ParfumtextField.setText(String.valueOf( ((Glace) produit).getParfum()));
            ParfumBox.getChildren().add(Parfum);
            ParfumBox.getChildren().add(ParfumtextField);




            LibelleBox.setSpacing(10);
            DatetextField.setText(String.valueOf( ((Glace) produit).getDatelimitConso()));
            DateBox.getChildren().add(Date);
            DateBox.getChildren().add(DatetextField);


            LibelleBox.setSpacing(10);
            TemptextField.setText(String.valueOf( ((Glace) produit).getTemperatureConservation() ));
            TempBox.getChildren().add(Temperature);
            TempBox.getChildren().add(TemptextField);

            topBox.getChildren().add(ParfumBox);
            topBox.getChildren().add(DateBox);

        }


        typeProduitchoiceBox.getItems().addAll("stylo","cartepostal","pain","glace");
        typeProduitBox.getChildren().add(typeProduit);
        typeProduitBox.getChildren().add(typeProduitchoiceBox);

        topBox.getChildren().add(referenceBox);
        topBox.getChildren().add(LibelleBox);
        topBox.getChildren().add(MarqueBox);
        topBox.getChildren().add(PrixBox);
        topBox.getChildren().add(QuantiteBox);
        topBox.getChildren().add(typeProduitBox);



        buttomBox.setSpacing(10);
        buttomBox.getChildren().add(precedentButton);
        buttomBox.getChildren().add(nouveauButton);
        buttomBox.getChildren().add(enregistrerButton);
        buttomBox.getChildren().add(suprimerButton);
        buttomBox.getChildren().add(suivantButton);


        root.getChildren().add(topBox);
        root.getChildren().add(buttomBox);

    }


    public static void main(String[] args) {
        launch();
    }

}