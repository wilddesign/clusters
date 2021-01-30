# clusters
Molecular graph analysis with Spring MVC


I have to learn Java, so this is my training CRUD project.
During my MSc studies I have obtained several polymetallic clusters and we were able to measure their crystal structures into cif files.

Metal centers bear their properties: electric (don't forget the spectroscopic, which include vibrational, rotational and electronic), magnetic and chiral. Interestingly, their collective behavior gives rise to interesting properties of the crystal containing these clusters. Essentially, this program is going to store cluster structures and calculate these properties. A lot of them may be calculated. And a lot will*.
Additionally, functions involving machine learning algorithms will be employed.

Back end will be created in Spring MVC. Front end in React. I will use Singleton deign pattern. The loaded
database of molecular bonds will be the single instance of the cluster. Individual server endpoints will use it for their purposes.

Domain model:
There are clusters. They are sets of atoms of different kinds(tungsten, cobalt, nickel, carbon, nitrogen, oxygen) and internal properties (charge, spin, spin direction) with bonds between them, characterized by length. Essentially, they are graphs. It is important to be able to extract their subsets and perform calculations on them. Such a subset is an object that implements an interface used to calculated stuff.


*They are not real scientific calculations, just a Java & MySQL training project.
