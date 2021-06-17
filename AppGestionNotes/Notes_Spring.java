


















// Big Problems  othrs are easy
//OneToOne
// manytoMany
/**
 * http://blog.paumard.org/cours/jpa/chap03-entite-relation.html
 * https://koor.fr/Java/TutorialJEE/jee_jpa_one_to_one.wp
 * https://www.jmdoudoux.fr/java/dej/chap-hibernate.htm
 */

create table with two primary key => equals hash code+twotable
@transit == ignore the value suivant pour la persistance [value / obj = colomn ] 
car any objet dans db doit etre serialisable => sinon on peut ajouter une stategie @onetomany ...
@JsonIgnore pour l'envoie ses objet json/restfulapi => casser les boucles infinis 
[marche avec transit pour resoudre]

heritage :
class mere = @enhiritace(strategie=class_per_table)
cfils extend mere + chaque obj fils a son duplication des id de class mere + other attr+ new attr[his own]
strategie=singletable + @discrinitaredColumn(name="")
strategie =joined [best one]


///
@Entity
@enhiritace(strategie=table_per_class)
//les childs vont avoir le meme info que Personne + thiere data
//Pb de Savoir la liste totale des personne (il faut faire 3 join entre les 3table => pour avoir l'ensemble)
public class Personne{

}

@Entity
public class prof extends Personne{
    private int numSome;
    private int indice = 500;
    prof(){
        super();//
    
    }
}
public class student extend Personne{
    private int 
}

************strategie 2:
Une seul Table + Colomn Coucou + ne marche que avec des attribut Nullable , sinon on doit ajouter traitement/validation dans Java , et cela n'est pas applique directemenet sur Databasae
=> traitement des data specifique .. mais en generale , on pose les contraintes sur la BD , pour aller plus vide 

@enhiritace(strategie=Single_table)//Personne
@discrinitaredColumn(name="Coucou" , DFescrType=int)
@DescyValue("1") //sont des opinions , et spring a ses opinions par default



@Entity //Student
@DescyValue("2")

@Entity //Prof
@DescyValue("3")

************strategie 3:
// on va avoir 3 tables, etudaint has his own data , also prof , avec un cles etrang dans personne OneToOne ..
//on peut travailler avec des data nullable ,, mais ca nessite l'administration des bd .. creation des index .. [
la base du prod etstt generalement Geante    
]
strategie =joined 


@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

Les Relations :

 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 //Hibernate deals with objects :
/*
pblc interface PersonneRepository extends JPaRepo<Personne Long>
@Query("select p.nom from Personne p") 
//p.nom c'est ER de java , et personne est un OBJET , nom d'attribut is counted , et nom pas les 
//HQL : longaue qui permet de traduire le codede programmeur vers sql , hibernate fait pour les programmeur , et nom pas les administrateur bd
publoic List<persnne> findBiemial(string email)
*/
@Entity //Darouri pour que yhandli la relation en bd
 public class compte {
     //il nous faut un id bidirectionnel
     @id
     private long id;
     //cad il faut enregitrer un compte avec personne , 
     //car le cle "etranger" va etre dans personne 
     private String Emial;
     private String password;
     private boolean active;
     public Compte(){
         super();
     }
 }


 public class Personne {
     private OtherData D_desPerosnne ;
     @OneToOne("**") //la specification des cascades[creation , MAJ] est optionnel
   
     //* 
     //  fitch=
    //  lazy=
    //  playEgle=..
     //il fauit imperativeemtn dir how to deal with this attr :
     private Compte comte ;
 }



 /********************************/
 //si dans le cas ou le premier cree c'est le personne et puis on le affecte un Compte , il faut inverser cette one to one vers Personne
 @Entity //Darouri pour que yhandli la relation en bd
 public class compte {
   @id
     private long id;
     private String Emial;
     private String password;
     private boolean active;
     @OneToOne
     @JoinColumn(name="coucou" ,ReferencedColomnName="coucou")//je veux la jointure avec mon columns matricule , reference avec id
     private Personne personne;
     public Compte(){
         super();
     }
 }


 public class Personne {
     @id
     private int matricule;
     private OtherData D_desPerosnne ;
 }



  /********************************/
 @Entity //Darouri pour que yhandli la relation en bd
 public class compte {
    @id
     private long id;
     private String Emial;
     private String password;
     private boolean active;
     @OneToOne
     @JoinColumn(name="coucou" ,ReferencedColomnName="coucou")//je veux la jointure avec mon columns matricule , reference avec id
     //il doit touver column coucou dans personne , sinon Error!
     private Personne personne;
     public Compte(){
         super();
     }
 

/**
 * JoindedColumn n'est pas la bonne sol , il cree un autre collumn au lieu de lieer les deux id .. , on va prendre une autre annotation 
 */
     






  /**
  *  Many to many = adding table association
  et por les lier , on ajoute des annotation sql que cette fois [on sort de l'OO] , pour l'aider presiser la liason
   */  

 public class Personne {
    @id
    @Column("coucou")
    private int matricule;
    private OtherData D_desPerosnne ;
}


/*****in Personne*/
@onetoone(mappedby="Compte  [le nom d'attr dans la table Comte]" ) // cree l compte 3ad cree personne







// Un student has many Notes : manytoone 

public class Student{
    @id 
    private int matricule;
    @onetomany(mappedby="student [le nom d'attr dans Notes]")
    private list <Note> notes =new ArrayList<>(); //pour qu'il soit un objet null lors des rappelles 
}
public class Note{
    @id 
    private int id;
    @ManyToOne
    private Student student;
}
 //Cas Bidirectionel 
 public class Student{
    @id 
    private int matricule;
    @onetomany
    private list <Note> notes =new ArrayList<>(); //pour qu'il soit un objet null lors des rappelles 
}
public class Note{
    @id 
    private int id;
    @ManyToOne
    @JoinColumn(name="matricule[c'est le nom chez sql]")
    private Student student;
}
//see the changes ;)


//puisque que le student needs Notes : UNIdirectionnel
public class Student{
    @id 
    private int matricule;
    @onetomany
    private list <Note> notes =new ArrayList<>(); //pour qu'il soit un objet null lors des rappelles 
}
public class Note{
    @id 
    private int id;
}












/**
 *  Many to many = adding table association
 et por les lier , on ajoute des annotation sql que cette fois [on sort de l'OO] , pour l'aider presiser la liason
  */  

@Entity //Darouri pour que yhandli la relation en bd
public class compte {
   @id
    private long id;
    private String Emial;
    private String password;
    private boolean active;
    @OneToOne
    @JoinColumn(name="matricule" ,ReferencedColomnName="matricule")//je veux la jointure avec mon columns matricule , reference avec id
    //new comums to associate the two ids we have in the two tables
    private Personne personne;
    public Compte(){
        super();
    }



 //We cant do mapped by in the two sens [compote et personne] dans la relation one to one bidirectionnel OnetoOne(MappedBy ["moncleetrangere dans l'autre table"])



//ManyTo many : mult profs had many matieres
//we solve it normaly by intermediate tables two* manutoone
public class Professeus{
    private int indice =500;
    @Manytomany(MappedBy="professeurs")
    private list <Note> matires =new ArrayList<>(); //pour qu'il soit un objet null lors des rappelles 
}
public class Matires{
    @id 
    private int id;
    private String nom;
    @Manytomany
    private list <Note> professeurs =new ArrayList<>(); //pour qu'il soit un objet null lors des rappelles 

}

//cahque matire a plusiers notes [one to many]
Matiere{
    @onetomany(mappedby="matire [qui exist dans notes]")
    private List<Notes> notes = new ArrayList<Notes>();// important !

}



@Query("Hql" Or Native)//That why spring data is created , to  note creat sql in java => mauvaise performance ,,
@Query( Native="select * from personne whre nom like ? and prenom like ?")//That why spring data is created , to  note creat sql in java => mauvaise performance ,,
public List<personne>  findBuNameAndByPrenom(String nom, String prenpm);

///
//HQL Spring data
@Query("Select * form ppersonne p where p.nom like :nom and prenom like :coucou" )
public List<personne>  findBuNameAndByPrenom( @Param(value ="nom") String nom,@Param(Value="coucou")  String prenpm);
//





/*Themleaf :

class _> annotation -> repository -> controller [acion with th:action ..] 
autobinging .. 
soringRoo = fichier txt [like diag des class => il genere tout le code]
*/
// th:text object action






// 
// 
// 
// Revision Finale 
// 
// 
// 



devtools
Lombok
Actuator
Data JPa
Mysql Driver
security
thymeleaf
web
validator 
/*
Sppring Actuator Pour les Tests
Validator : valider les data en interaction avec la base select/insert
On disactive : devtools [a la fin _controler ]  +security [a la fin]
*/

/////
#dans les problemes de timezone..
#spring.datasource.url=jdbc:mysql://localhost:3306/location?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.url=jdbc:mysql://localhost:3306/location
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
#you should turn it to 'None' after
spring.jpa.hibernate.ddl-auto=create-drop

#il etait 5
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
spring.jpa.show-sql=true
server.port=8081
spring.thymeleaf.cache=false
#########
#spring.jpa.generate-ddl=true
#logging.level.org.hibernate.SQL= DEBUG
///
/actuator/health
Pagination 
@autowired
ModelNameRepository md;
md.findAll(PageRequest.of(5,20));//on va avoir une page de personne de page 5, et de quntite 20
/////
long = 1L 31L
for Date use LocalDate
List<Personne> : import java.util.List;
@NotNull : import javax.validation.constraints.NotNull;
@Entity : import javax.persistence.Entity;
Page : import org.springframework.data.domain.Page;
Pageable : import org.springframework.data.domain.Pageable;
Make sure all your package are under the package containing main class
@Enumerated(EnumType.STRING) : enregister les index des Enum en String ps ph.. not in int
 class dog exten Animale , Id de dog est deja l'Id de l'Animal , pas besoin de faire un deuxieme id.

 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) long id;
 dans les jointure :
 import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
/**ManyTomany */
Dans Une entite :
 @ManyToMany(fetch=FetchType.EAGER)
	 @JoinTable(
			 name="Profs_Matieres",
			 joinColumns= @JoinColumn(name="id_matiere"),//la colonne qui va faire la jointure
			 inverseJoinColumns =@JoinColumn(name="Id_Professeur")//
			 )
	 private Set<Professeur> professeurs = new HashSet<Professeur>();
   
////
///
//
//
///
////
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "professeurs[l'objet exact]")
	private Set<Matiere> matires = new HashSet<Matiere>();


/**OneToOne */
@OnetoOne()
@JoinColumn(
    name="matricule[attribut de jointure de class currente _Doit etre la meme cote sql (ou cas ou on a fait @Colom(name="coucou") private long cava => il doit etre coucou))_!!_]"),
    ReferencedColomnName ='id',//puisque il vont etre des cle  etrangere d'autre table , il ne faut pas les toucher
    insertable=false,
///
//
//
///
	@OneToOne(mappedBy = "compte")
	private Personne personne;
    //Pay attention ici , il faut cree une personne Avant que son Compte

/*OneToMany*/

//https://github.com/EMI-PI-s4-grp8/ApplicationLocation.git
//https://github.com/Reda-ELOUAHABI/JEE_SpringBoot_Exam.git

	@RequestMapping(value = "/ajouterprofesseur", method = RequestMethod.POST)
	public String ajouterNote(Model model, Long matricule, String nom, String prenom, String datenaissance,
			int numSomme, GradeType grade, String email, @RequestParam("password" d ,defaultValue="123")String password) 
























[02:28, 17/06/2021] soufiane alamou: <!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    List of all students
    <form th:action="@{/etudiants}" method="get">
        <label>Chercher un etudiant par Nom:</label><br>
        <input type="text" name="nomStudent"><br>
        <input type="submit" value="Chercher">
    </form>
    <table>
        <thead>
        <tr>
            <th><a th:href =@{/etudiantsTri} >Nom</a></th>
            <th>Prenom</th>
            <th>Matricule</th>
            <th>Date naissance</th>
            <th>niveau</th>
            <th>Anne de reserve ? </th>
            <th>Notes de l'etudiant</th>
        </tr>
        </thead>
        <tbody>
            <tr th:each="student : ${students}" >
                <td th:text="${student.Nom}"></td>
                <td th:text="${student.Prenom}"></td>
                <td th:text="${student.Matricule}"></td>
                <td th:text="${student.date_naissance}"></td>
                <td th:text="${student.niveau}"></td>
                <td th:if="${student.anneeReserve == 0}">Oui</td>
                <td th:unless="${student.anneeReserve == 0}">Non</td>
                <td><a th:href="@{showNotes/{matricule}(matricule=${student.matricule})}">Consulter les notes de cet etudiant</a></td>

            </tr>

        </tbody>
    </table>
</body>
</html>

import com.example.demo.Model.Etudiant;
import com.example.demo.Model.Note;
import com.example.demo.Repository.EtudiantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private EtudiantRepo etudiantRepo;

    @RequestMapping(value = "/etudiants", method = RequestMethod.GET)
    public String allStudent(Model model, String nomStudent){
        if(nomStudent!= null){
            model.addAttribute("students", this.etudiantRepo.findByNom(nomStudent));
        }
        else{
            model.addAttribute("students",this.etudiantRepo.findAll());
        }
        return "Students";
    }
    @GetMapping("/showNotes/{matricule}")
    public String showNotes(@PathVariable(value = "matricule") int matricule, Model model){
        Etudiant etudiant = this.etudiantRepo.findById(matricule).get();
        List<Note> notesEtudiant = etudiant.getNotes();
        model.addAttribute("notes", notesEtudiant);
        return "NotesEtudiants";
    }
    @RequestMapping(value = "/etudiantsTri", method = RequestMethod.GET)
    public String allStudentTri(Model model){
        model.addAttribute("students", this.etudiantRepo.findAllByOrderByNom());
        return "Students";
    }
}


import com.example.demo.Model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant, Integer> {
    List<Etudiant> findByNom(String nom);
    List<Etudiant> findAllByOrderByNom();

    //@Query(value = "SELECT e FROM Etudiant e ORDER BY e.nom")
    @Query(nativeQuery = true, value = "SELECT * FROM etudiant ORDER BY nom")
    List<Etudiant> etudiantTri();

}