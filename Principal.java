package testeTI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Principal {
    public static void main(String[] args) {
    	
    	//Inserir funcionarios
    	
    	List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 02), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloisa", LocalDate.of(2003, 5, 24), new BigDecimal("1686.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
        
        // Remover o funcionário Joao
        funcionarios.removeIf(funcionario -> funcionario.nome.equals("João"));

        // Imprimir todos os funcionários
        // Esse nao sei fazer        
       System.out.println("Nome: " + funcionario.nome + ", Data de Nascimento: " + funcionario.dataNascimento.getDay() + "/" +
                funcionario.dataNascimento.getMonthValue() + "/" + funcionario.dataNascimento.getYear() +
                ", Salário: " + funcionario.salario + ", Função: " + funcionario.funcao));

 
                    BigDecimal salarioAtualizado = funcionario.getSalario().multiply(new BigDecimal("1.10"));
                    funcionario.setSalario(salarioAtualizado);

        // Agrupar por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream().collect(Collectors.groupingBy(f -> f.funcao));

        // Imprimir funcionários agrupados por função
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(funcionario -> System.out.println("\tNome: " + funcionario.nome));
        });

        // Imprimir funcionários que fazem aniversário em outubro e dezembro
        funcionarios.stream()
                .filter(funcionario -> funcionario.dataNascimento.getMonthValue() == 10 || funcionario.dataNascimento.getMonthValue() == 12)
                .forEach(funcionario -> System.out.println("Nome: " + funcionario.nome +
                        ", Data de Nascimento: " + funcionario.dataNascimento.getDayOfMonth() + "/" +
                        funcionario.dataNascimento.getMonthValue() + "/" + funcionario.dataNascimento.getYear()));

        // Imprimir funcionário com maior idade
        Funcionario funcionarioMaisVelho = funcionarios.stream()
                .max(Comparator.comparing(f -> f.dataNascimento))
                .orElseThrow(NoSuchElementException::new);

        System.out.println("Funcionário mais velho: " + funcionarioMaisVelho.nome +
                ", Idade: " + (LocalDate.now().getYear() - funcionarioMaisVelho.dataNascimento.getYear()));

        // Ordenar funcionários por nome
 //       funcionarios.sort(Comparator.comparing(f -> f.nome));

        // Imprimir funcionários em ordem alfabética
  //      funcionarios.forEach(funcionario -> System.out.println("Nome: " + funcionario.nome));

        // Imprimir o total dos salários dos funcionários
 //       BigDecimal totalSalarios = funcionarios.stream()
  //              .map(Funcionario::getSalario)
   //             .reduce(BigDecimal.ZERO, BigDecimal::add);

   //     System.out.println("Total dos salários: " + totalSalarios);

        // Imprimir quantos salários mínimos ganha cada funcionário
//    BigDecimal salarioMinimo = new BigDecimal("1500.00");
//     funcionarios.forEach(funcionario -> {
//          BigDecimal numSalariosMinimos = funcionario.salario.divide(salarioMinimo, 2, BigDecimal.ROUND_DOWN);
 //           System.out.println(funcionario.nome + " ganha " + numSalariosMinimos + " salários mínimos");
//        });
    }
}
