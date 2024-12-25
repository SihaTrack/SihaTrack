package com.eniad.sihatrack_v_1.ui.userActivities.articles;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eniad.sihatrack_v_1.R;

import java.util.ArrayList;

public class DiabetesArticlsActivity extends AppCompatActivity {

    private RecyclerView articlRecyclerView;
    private ArticlAdapter adapter;
    private ArrayList<Articl> articls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_diabetes_articls);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        articlRecyclerView = findViewById(R.id.diabetesArticlRecyclerView);
        articls = new ArrayList<>();
        articls.add(new Articl("Comprendre le diabète : Causes, Symptômes et Prévention",
                "image1.PNG",
                "Le diabète est une maladie chronique qui se manifeste par un taux élevé de glucose dans le sang (également appelé glycémie). Il existe deux types principaux de diabète : le diabète de type 1 et le diabète de type 2. Ce dernier est le plus répandu et est souvent lié à des habitudes de vie modifiables telles que l'alimentation et l'activité physique.",
                "Causes du diabète\n" +
                        "Le diabète de type 1 est causé par une réaction auto-immune dans laquelle le système immunitaire attaque les cellules productrices d'insuline du pancréas. En revanche, le diabète de type 2 résulte de l'incapacité du corps à utiliser efficacement l'insuline produite, souvent en raison de l'obésité, du surpoids et de l'inactivité physique.\n" +
                        "\n" +
                        "Symptômes du diabète\n" +
                        "Soif excessive\n" +
                        "Envie fréquente d'uriner\n" +
                        "Perte de poids inexpliquée\n" +
                        "Fatigue persistante\n" +
                        "Vision floue\n" +
                        "Prévention et Gestion\n" +
                        "Il est possible de prévenir le diabète de type 2 en adoptant des habitudes de vie saines. Voici quelques conseils :\n" +
                        "\n" +
                        "Adopter une alimentation équilibrée, riche en fruits, légumes et fibres.\n" +
                        "Maintenir un poids corporel sain.\n" +
                        "Pratiquer une activité physique régulière.\n" +
                        "Éviter la consommation excessive de sucre et d'aliments transformés.\n" +
                        "Conclusion\n" +
                        "Le diabète est une maladie sérieuse qui peut être gérée et prévenue par des changements de mode de vie. En adoptant des habitudes saines, il est possible de réduire le risque de développer un diabète de type 2 et d'améliorer la qualité de vie des personnes déjà atteintes par la maladie.",
                "https://www.who.int/fr/news-room/fact-sheets/detail/obesity-and-overweight"));
        articls.add(new Articl("Le Diabète : Comprendre ses causes, ses symptômes et sa prévention",
                "image2.jpg",
                "Le diabète est une maladie chronique qui survient lorsque le pancréas ne produit pas suffisamment d'insuline ou lorsque l'organisme ne parvient pas à utiliser efficacement l'insuline qu'il produit. Cette condition peut entraîner des complications graves si elle n'est pas gérée correctement.",
                "Les Différents Types de Diabète\n" +
                        "Diabète de type 1 : Le système immunitaire attaque les cellules productrices d'insuline. Ce type de diabète apparaît souvent à un jeune âge.\n" +
                        "Diabète de type 2 : Le corps devient résistant à l'insuline, et le pancréas ne peut pas produire suffisamment d'insuline pour maintenir une glycémie normale. Ce type est souvent lié à l'obésité et à un mode de vie sédentaire.\n" +
                        "Diabète gestationnel : Ce type de diabète se développe pendant la grossesse et disparaît généralement après l'accouchement, bien qu'il puisse augmenter le risque de diabète de type 2 plus tard.\n" +
                        "Les Symptômes du Diabète\n" +
                        "Les symptômes du diabète peuvent varier selon le type de diabète et incluent :\n" +
                        "\n" +
                        "Soif excessive\n" +
                        "Envie fréquente d'uriner\n" +
                        "Fatigue extrême\n" +
                        "Perte de poids inexpliquée\n" +
                        "Vision floue\n" +
                        "Prévention et Gestion\n" +
                        "Il est possible de prévenir le diabète de type 2 en adoptant des habitudes de vie saines. Voici quelques conseils :\n" +
                        "\n" +
                        "Adopter une alimentation équilibrée, riche en fruits, légumes et fibres.\n" +
                        "Maintenir un poids corporel sain.\n" +
                        "Pratiquer une activité physique régulière.\n" +
                        "Éviter la consommation excessive de sucre et d'aliments transformés.\n" +
                        "Conclusion\n" +
                        "Le diabète est une maladie sérieuse qui peut être gérée et prévenue par des changements de mode de vie. En adoptant des habitudes saines, il est possible de réduire le risque de développer un diabète de type 2 et d'améliorer la qualité de vie des personnes déjà atteintes par la maladie.\n" +
                        "\n" +
                        "Sources\n" +
                        "Organisation Mondiale de la Santé (OMS) - Obésité et surpoids\n" +
                        "Fédération Internationale du Diabète (IDF) - Atlas du diabète\n" +
                        "Haute Autorité de Santé (HAS) - Recommandations sur la prise en charge du diabète\n" +
                        "Ministère des Solidarités et de la Santé (France) - Accès aux soins et lutte contre les inégalités",
                "https://www.who.int/fr/news-room/fact-sheets/detail/diabetes"));
        articls.add(new Articl("Les Complications du Diabète et Comment les Prévenir",
                "image3.jpg",
                "Le diabète, s'il n'est pas bien géré, peut entraîner de nombreuses complications qui affectent divers organes et systèmes du corps. Ces complications peuvent être graves et nuire à la qualité de vie du patient. Heureusement, il est possible de les prévenir par une bonne gestion de la maladie.",
                "\n" +
                        "1. Complications du diabète\n" +
                        "1.1 Complications cardiovasculaires\n" +
                        "Le diabète augmente le risque de maladies cardiovasculaires telles que les crises cardiaques et les accidents vasculaires cérébraux (AVC). Les niveaux élevés de sucre dans le sang peuvent endommager les parois des vaisseaux sanguins et favoriser la formation de plaques d'athérome.\n" +
                        "\n" +
                        "1.2 Néphropathie diabétique\n" +
                        "La néphropathie diabétique est une maladie rénale qui peut survenir chez les personnes diabétiques. La présence prolongée de taux élevés de glucose dans le sang peut détériorer les reins, ce qui peut conduire à l'insuffisance rénale.\n" +
                        "\n" +
                        "1.3 Neuropathie diabétique\n" +
                        "La neuropathie diabétique affecte les nerfs, en particulier ceux des membres inférieurs. Elle peut provoquer des douleurs, des picotements, une perte de sensation ou des engourdissements. Cette condition augmente le risque d'ulcères du pied, pouvant conduire à des amputations.\n" +
                        "\n" +
                        "1.4 Rétinopathie diabétique\n" +
                        "La rétinopathie diabétique est une complication qui affecte les yeux. Les vaisseaux sanguins de la rétine peuvent être endommagés par des niveaux élevés de glucose, ce qui peut entraîner des problèmes de vision, voire la cécité.\n" +
                        "\n" +
                        "2. Prévention des complications\n" +
                        "Contrôle de la glycémie : Maintenir des niveaux de sucre dans le sang proches de la normale est essentiel pour prévenir les complications.\n" +
                        "Alimentation saine : Adopter un régime équilibré, riche en fibres et pauvre en sucre rapide, aide à contrôler la glycémie.\n" +
                        "Exercice physique : L'activité physique améliore la sensibilité à l'insuline et contribue à la réduction du taux de sucre dans le sang.\n" +
                        "Suivi médical régulier : Des bilans de santé réguliers permettent de détecter et de traiter les complications à un stade précoce.\n" +
                        "Arrêt du tabac : Le tabac aggrave les risques cardiovasculaires liés au diabète. Arrêter de fumer aide à préserver la santé.\n" +
                        "Conclusion\n" +
                        "Les complications du diabète peuvent être graves, mais elles ne sont pas inévitables. Avec une bonne gestion du diabète, une alimentation saine, de l'exercice régulier et des visites médicales régulières, il est possible de réduire le risque de ces complications et de maintenir une bonne qualité de vie.\n" +
                        "\n" +
                        "Sources\n" +
                        "Organisation Mondiale de la Santé (OMS) - Feuille d'information sur le diabète\n" +
                        "American Diabetes Association - Complications du diabète\n" +
                        "Mayo Clinic - Symptômes et causes du diabète\n" +
                        "CDC - Centres pour le Contrôle et la Prévention des Maladies",
                "https://www.diabetes.org/diabetes/complications"));

        adapter = new ArticlAdapter(this, articls, articl -> {
            ArticlDetailsFragment fragment = ArticlDetailsFragment.newInstance(
                    articl.getTitle(),
                    articl.getImage(),
                    articl.getParaghraph(),
                    articl.getContenu(),
                    articl.getUrl()
            );
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.articlfragmentContainer, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        articlRecyclerView.setLayoutManager(layoutManager);
        articlRecyclerView.setAdapter(adapter);
    }
}