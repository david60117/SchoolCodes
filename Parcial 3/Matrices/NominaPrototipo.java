import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

public class NominaPrototipo {

    String nom, rfc, tel, mes, user, password;
    boolean acces, conffaltas, confdom, confdesc, confpres, Confingreso, confAguinaldo, confPTU, confvac, confBono, confhrex;
    
    int i, dia, aniosServicio, diasVacaciones, FalAnio, diaingr, mesingr, diasAcumulados, diaInicialDelAnio;
    int DiasTranscurridos, DiasTrabajados, FalSem1, FalSem2, dom, descSem1, descSem2, hrexSem1, hrexSem2;
    int DiasTrabSem1, DiasTrabSem2;
    
    double UMA;
    double salhr, SalDia, SalSem1, SalSem2, SalBasQuin, SalAdDescSem1, SalAdDescSem2, TotSalDescSem1;
    double TotSalDescSem2, SalDesc, Salhrex2Sem1, Salhrex3Sem1, SalhrexSem1, Salhrex2Sem2, Salhrex3Sem2;
    double SalhrexSem2, Salhrex, PrimDom, Aguin, PrimaVacacional, PTUPagado, Prestamo, FactorIntegra, SBC;
    double EnfeYMaterEsp, EnfeYMaterDin, EnfeYMater, InvalYVida, RetiroCV, CuotaIMSS, LimiteExencion;
    double ExencionPotencialHrexSem1, BGSalhrex2Sem1, ExencionPotencialHrexSem2, BGSalhrex2Sem2, BGSalhrex;
    double ExencionPotencialDescSem1, BGSalDescSem1, ExencionPotencialDescSem2, BGSalDescSem2, BGSalDesc;
    double BGPrimDom, LimiteExencionAguin, BGAguin, LimiteExencionPTU, BGPTU, LimiteExencionPV;
    double BGPrimaVacacional, TotalSalario, TotalGravable, LimiteInferior, CuotaFija, TasaExcedente;
    double Excedente, ImpuestoMarginal, ISR, TotalDeducciones, SalaNeto, Bono;

    DecimalFormat df = new DecimalFormat("###,##0.00");

    // Creación de modulo Adrían Barrera Cruz 22/10/25 a las 11:14
    // Objetivo: Punto de entrada principal. Crea una instancia de la clase y llama al método que inicia el proceso.
    public static void main(String[] args) {
        NominaPrototipo nomina = new NominaPrototipo();
        nomina.iniciarProceso();
    }

    // Creación de modulo Adrían Barrera Cruz 22/10/25 a las 13:02
    // Objetivo: Controlar el flujo principal del programa en un bucle. Permite calcular múltiples nóminas hasta que el usuario decida salir.
    public void iniciarProceso() {
        while (true) {
            inicializarValores();
            
            if (!manejarLogin()) {
                break;
            }
            
            if (!pedirDatosEmpleado()) {
                continue;
            }
            
            if (!pedirDatosNominaWizard()) { 
                continue;
            }
            
            realizarCalculos();
            mostrarDetalleCalculos();
            
            if (!mostrarReciboFinal()) {
                break;
            }
        }
    }

    // Creación de modulo Adrían Barrera Cruz 22/10/25 a las 15:20
    // Objetivo: Reiniciar todas las variables globales a sus valores por defecto (0, "", o false) antes de iniciar un nuevo cálculo de nómina.
    public void inicializarValores() {
        nom = rfc = tel = mes = user = password = "";
        acces = conffaltas = confdom = confdesc = confpres = Confingreso = confhrex = confvac = confBono = false;
        confAguinaldo = false;
        confPTU = false;
        
        i = dia = aniosServicio = diasVacaciones = FalAnio = diaingr = mesingr = diasAcumulados = diaInicialDelAnio = 0;
        DiasTranscurridos = DiasTrabajados = FalSem1 = FalSem2 = dom = descSem1 = descSem2 = hrexSem1 = hrexSem2 = 0;
        DiasTrabSem1 = DiasTrabSem2 = 0;

        UMA = 113.14;
        salhr = SalDia = SalSem1 = SalSem2 = SalBasQuin = SalAdDescSem1 = SalAdDescSem2 = TotSalDescSem1 = 0.0;
        TotSalDescSem2 = SalDesc = Salhrex2Sem1 = Salhrex3Sem1 = SalhrexSem1 = Salhrex2Sem2 = Salhrex3Sem2 = 0.0;
        SalhrexSem2 = Salhrex = PrimDom = Aguin = PrimaVacacional = PTUPagado = Prestamo = FactorIntegra = SBC = 0.0;
        EnfeYMaterEsp = EnfeYMaterDin = EnfeYMater = InvalYVida = RetiroCV = CuotaIMSS = LimiteExencion = 0.0;
        ExencionPotencialHrexSem1 = BGSalhrex2Sem1 = ExencionPotencialHrexSem2 = BGSalhrex2Sem2 = BGSalhrex = 0.0;
        ExencionPotencialDescSem1 = BGSalDescSem1 = ExencionPotencialDescSem2 = BGSalDescSem2 = BGSalDesc = 0.0;
        BGPrimDom = LimiteExencionAguin = BGAguin = LimiteExencionPTU = BGPTU = LimiteExencionPV = 0.0;
        BGPrimaVacacional = TotalSalario = TotalGravable = LimiteInferior = CuotaFija = TasaExcedente = 0.0;
        Excedente = ImpuestoMarginal = ISR = TotalDeducciones = SalaNeto = Bono = 0.0;
    }
    
    // Creación de modulo Adrían Barrera Cruz 22/10/25 a las 17:45
    // Objetivo: Gestionar el acceso al sistema. Muestra un diálogo de login, valida las credenciales y maneja los intentos fallidos con bloqueo temporal.
    public boolean manejarLogin() {
        acces = false;
        i = 0;
        JTextField userField = new JTextField(15);
        JPasswordField passField = new JPasswordField(15);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Usuario:"));
        panel.add(userField);
        panel.add(new JLabel("Contraseña:"));
        panel.add(passField);

        while (!acces) {
            userField.setText("");
            passField.setText("");
            int opcion = JOptionPane.showConfirmDialog(null, panel, "ACCESO (CODE & GO)", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (opcion == JOptionPane.OK_OPTION) {
                user = userField.getText();
                password = new String(passField.getPassword());
                if ("GuillermoUAEH".equals(user) && "AdminUAEH".equals(password)) {
                    acces = true;
                } else {
                    i++;
                    String mensajeError = String.format("Contraseña o usuario incorrecto. Volver a intentar.\nTienes %d intentos restantes.", 3 - i);
                    JOptionPane.showMessageDialog(null, mensajeError, "ACCESO", JOptionPane.WARNING_MESSAGE);
                }
                if (i == 3) {
                    JOptionPane.showMessageDialog(null, "Espere 30 seg para volverlo a intentar", "BLOQUEADO", JOptionPane.ERROR_MESSAGE);
                    try { TimeUnit.SECONDS.sleep(30); } catch (InterruptedException e) { e.printStackTrace(); }
                    i = 0;
                }
            } else {
                return false;
            }
        }
        return true;
    }
    
    // Creación de modulo Adrían Barrera Cruz 23/10/25 a las 09:33
    // Objetivo: Solicitar y validar los datos básicos del empleado (Nombre, RFC, Teléfono) mediante un diálogo.
    public boolean pedirDatosEmpleado() {
        JTextField nomField = new JTextField(20);
        JTextField rfcField = new JTextField(13);
        JTextField telField = new JTextField(10);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nombre:"));
        panel.add(nomField);
        panel.add(new JLabel("RFC:"));
        panel.add(rfcField);
        panel.add(new JLabel("Teléfono:"));
        panel.add(telField);

        while (true) {
            int opcion = JOptionPane.showConfirmDialog(null, panel, "Ingresa los datos del empleado", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (opcion == JOptionPane.OK_OPTION) {
                nom = nomField.getText();
                rfc = rfcField.getText();
                tel = telField.getText();
                if (nom.isEmpty() || rfc.isEmpty() || tel.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }
    }

    // Creación de modulo Adrían Barrera Cruz 23/10/25 a las 11:05
    // Objetivo: Orquestar la captura de todos los datos de la nómina (percepciones y deducciones) en una secuencia lógica (tipo "wizard").
    public boolean pedirDatosNominaWizard() {
        
        if (!pedirDatosPeriodo()) return false;
        if (!pedirDatosSalarioVacaciones()) return false;
        if (!pedirDatosFaltas()) return false;
        
        if (mes.equalsIgnoreCase("diciembre")) {
            if (!pedirDatosAguinaldo()) return false;
        }
        if (mes.equalsIgnoreCase("marzo")) {
            if (!pedirDatosPTU()) return false;
        }
        
        if (!pedirDatosDomingosDescansos()) return false;
        if (!pedirDatosHorasExtra()) return false;
        if (!pedirDatosBono()) return false;
        if (!pedirDatosPrestamo()) return false;
        
        return true;
    }

    // Creación de modulo Adrían Barrera Cruz 23/10/25 a las 12:19
    // Objetivo: Solicitar el día y el mes del periodo de pago que se está calculando.
    private boolean pedirDatosPeriodo() {
        JTextField diaField = new JTextField(5);
        JTextField mesField = new JTextField(10);
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Día (número):"));
        panel.add(diaField);
        panel.add(new JLabel("Mes (nombre):"));
        panel.add(mesField);
        
        while (true) {
            int opcion = JOptionPane.showConfirmDialog(null, panel, "PERIODO", 
                                                       JOptionPane.OK_CANCEL_OPTION, 
                                                       JOptionPane.PLAIN_MESSAGE);
            if (opcion != JOptionPane.OK_OPTION) return false;

            try {
                dia = Integer.parseInt(diaField.getText());
                mes = mesField.getText();
                if (mes.isEmpty()) throw new Exception("El mes no puede estar vacío.");
                if (dia < 1 || dia > 31) throw new Exception("Día inválido.");
                return true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Datos de periodo inválidos. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Creación de modulo Adrían Barrera Cruz 23/10/25 a las 14:50
    // Objetivo: Recopilar el salario por hora, los años de servicio y confirmar si el empleado tomó vacaciones en esta quincena.
    private boolean pedirDatosSalarioVacaciones() {
        JTextField salhrField = new JTextField(10);
        JTextField aniosField = new JTextField(10);
        
        JRadioButton rbVacSi = new JRadioButton("Sí");
        JRadioButton rbVacNo = new JRadioButton("No");
        rbVacNo.setSelected(true);
        ButtonGroup bgVac = new ButtonGroup();
        bgVac.add(rbVacSi); bgVac.add(rbVacNo);
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Salario por hora ($):"));
        panel.add(salhrField);
        panel.add(new JLabel("Años de servicio:"));
        panel.add(aniosField);
        panel.add(new JLabel("¿Tomó periodo vacacional esta quincena?"));
        JPanel radioPanel = new JPanel();
        radioPanel.add(rbVacSi); radioPanel.add(rbVacNo);
        panel.add(radioPanel);
        
        while (true) {
            int opcion = JOptionPane.showConfirmDialog(null, panel, "SONDEO DE PERCEPCIONES (Salario)", 
                                                       JOptionPane.OK_CANCEL_OPTION, 
                                                       JOptionPane.PLAIN_MESSAGE);
            if (opcion != JOptionPane.OK_OPTION) return false;

            try {
                salhr = Double.parseDouble(salhrField.getText());
                aniosServicio = Integer.parseInt(aniosField.getText());
                if (salhr <= 0 || aniosServicio < 0) throw new Exception("Los valores deben ser positivos.");
                
                confvac = rbVacSi.isSelected();
                return true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Datos inválidos. Ingrese números correctos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Creación de modulo Adrían Barrera Cruz 23/10/25 a las 16:22
    // Objetivo: Preguntar si el empleado tuvo faltas y, en caso afirmativo, registrar el número de faltas para cada semana.
    private boolean pedirDatosFaltas() {
        JRadioButton rbSi = new JRadioButton("Sí");
        JRadioButton rbNo = new JRadioButton("No");
        rbNo.setSelected(true);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbSi); bg.add(rbNo);

        JTextField falSem1Field = new JTextField(5);
        JTextField falSem2Field = new JTextField(5);
        
        falSem1Field.setEnabled(false);
        falSem2Field.setEnabled(false);

        rbSi.addActionListener(e -> {
            falSem1Field.setEnabled(true);
            falSem2Field.setEnabled(true);
        });
        rbNo.addActionListener(e -> {
            falSem1Field.setEnabled(false);
            falSem2Field.setEnabled(false);
            falSem1Field.setText("");
            falSem2Field.setText("");
        });
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("¿Tuvo faltas esta quincena?"));
        JPanel radioPanel = new JPanel();
        radioPanel.add(rbSi); radioPanel.add(rbNo);
        panel.add(radioPanel);
        
        panel.add(new JLabel("Faltas semana 1:"));
        panel.add(falSem1Field);
        panel.add(new JLabel("Faltas semana 2:"));
        panel.add(falSem2Field);
        
        while (true) {
            int opcion = JOptionPane.showConfirmDialog(null, panel, "SONDEO DE PERCEPCIONES (Faltas)", 
                                                       JOptionPane.OK_CANCEL_OPTION, 
                                                       JOptionPane.PLAIN_MESSAGE);
            if (opcion != JOptionPane.OK_OPTION) return false;

            conffaltas = rbSi.isSelected();
            
            if (conffaltas) {
                try {
                    FalSem1 = Integer.parseInt(falSem1Field.getText());
                    FalSem2 = Integer.parseInt(falSem2Field.getText());
                    if (FalSem1 < 0 || FalSem2 < 0) throw new Exception("No se admiten negativos.");
                    return true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingrese números válidos (0 o más) para las faltas.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                FalSem1 = 0;
                FalSem2 = 0;
                return true;
            }
        }
    }

    // Creación de modulo Adrían Barrera Cruz 24/10/25 a las 10:07
    // Objetivo: (Solo si es diciembre) Preguntar si se debe calcular el aguinaldo, solicitando faltas anuales y fecha de ingreso si es necesario.
    private boolean pedirDatosAguinaldo() {
        JRadioButton rbAguinaldoSi = new JRadioButton("Sí");
        JRadioButton rbAguinaldoNo = new JRadioButton("No");
        rbAguinaldoNo.setSelected(true);
        ButtonGroup bgAguinaldo = new ButtonGroup();
        bgAguinaldo.add(rbAguinaldoSi); bgAguinaldo.add(rbAguinaldoNo);
        
        JTextField falAnioField = new JTextField(5);
        
        JRadioButton rbIngresoSi = new JRadioButton("Sí");
        JRadioButton rbIngresoNo = new JRadioButton("No");
        rbIngresoNo.setSelected(true);
        ButtonGroup bgIngreso = new ButtonGroup();
        bgIngreso.add(rbIngresoSi); bgIngreso.add(rbIngresoNo);
        
        JTextField diaIngrField = new JTextField(5);
        JTextField mesIngrField = new JTextField(5);
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        JPanel radioAguinaldoPanel = new JPanel();
        radioAguinaldoPanel.add(rbAguinaldoSi); radioAguinaldoPanel.add(rbAguinaldoNo);
        
        JPanel radioIngresoPanel = new JPanel();
        radioIngresoPanel.add(rbIngresoSi); radioIngresoPanel.add(rbIngresoNo);
        
        falAnioField.setEnabled(false);
        rbIngresoSi.setEnabled(false);
        rbIngresoNo.setEnabled(false);
        diaIngrField.setEnabled(false);
        mesIngrField.setEnabled(false);

        rbAguinaldoSi.addActionListener(e -> {
            falAnioField.setEnabled(true);
            rbIngresoSi.setEnabled(true);
            rbIngresoNo.setEnabled(true);
            if (rbIngresoSi.isSelected()) {
                diaIngrField.setEnabled(true);
                mesIngrField.setEnabled(true);
            }
        });
        
        rbAguinaldoNo.addActionListener(e -> {
            falAnioField.setEnabled(false);
            rbIngresoSi.setEnabled(false);
            rbIngresoNo.setEnabled(false);
            diaIngrField.setEnabled(false);
            mesIngrField.setEnabled(false);
            falAnioField.setText("");
            diaIngrField.setText("");
            mesIngrField.setText("");
            rbIngresoNo.setSelected(true);
        });
        
        rbIngresoSi.addActionListener(e -> {
            diaIngrField.setEnabled(true);
            mesIngrField.setEnabled(true);
        });
        
        rbIngresoNo.addActionListener(e -> {
            diaIngrField.setEnabled(false);
            mesIngrField.setEnabled(false);
            diaIngrField.setText("");
            mesIngrField.setText("");
        });
        
        panel.add(new JLabel("¿Deseas calcular el aguinaldo en esta quincena?"));
        panel.add(radioAguinaldoPanel);
        panel.add(new JLabel("Faltas no justificadas a lo largo del año:"));
        panel.add(falAnioField);
        panel.add(new JLabel("¿Ingresó a trabajar este año?"));
        panel.add(radioIngresoPanel);
        panel.add(new JLabel("Día (número):"));
        panel.add(diaIngrField);
        panel.add(new JLabel("Mes (número, 1-12):"));
        panel.add(mesIngrField);

        while (true) {
            int opcion = JOptionPane.showConfirmDialog(null, panel, "SONDEO DE PERCEPCIONES (Aguinaldo)", 
                                                       JOptionPane.OK_CANCEL_OPTION, 
                                                       JOptionPane.PLAIN_MESSAGE);
            if (opcion != JOptionPane.OK_OPTION) return false;
            
            confAguinaldo = rbAguinaldoSi.isSelected();
            
            if (confAguinaldo) {
                try {
                    FalAnio = Integer.parseInt(falAnioField.getText());
                    if (FalAnio < 0) throw new Exception("Faltas no pueden ser negativas.");
                    
                    Confingreso = rbIngresoSi.isSelected();
                    if (Confingreso) {
                        diaingr = Integer.parseInt(diaIngrField.getText());
                        mesingr = Integer.parseInt(mesIngrField.getText());
                        if (diaingr < 1 || diaingr > 31 || mesingr < 1 || mesingr > 12) {
                            throw new Exception("Fecha de ingreso inválida.");
                        }
                    } else {
                        diaingr = 0;
                        mesingr = 0;
                    }
                    return true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                FalAnio = 0;
                Confingreso = false;
                diaingr = 0;
                mesingr = 0;
                return true;
            }
        }
    }

    // Creación de modulo Adrían Barrera Cruz 24/10/25 a las 11:46
    // Objetivo: (Solo si es marzo) Preguntar si se debe incluir el pago de PTU (Participación de los Trabajadores en las Utilidades) y el monto.
    private boolean pedirDatosPTU() {
        JRadioButton rbSi = new JRadioButton("Sí");
        JRadioButton rbNo = new JRadioButton("No");
        rbNo.setSelected(true);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbSi); bg.add(rbNo);

        JTextField ptuField = new JTextField(10);
        ptuField.setEnabled(false);

        rbSi.addActionListener(e -> ptuField.setEnabled(true));
        rbNo.addActionListener(e -> {
            ptuField.setEnabled(false);
            ptuField.setText("");
        });
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("¿Deseas agregar el PTU en esta quincena?"));
        JPanel radioPanel = new JPanel();
        radioPanel.add(rbSi); radioPanel.add(rbNo);
        panel.add(radioPanel);
        panel.add(new JLabel("Ingrese el monto:"));
        panel.add(ptuField);
        
        while (true) {
            int opcion = JOptionPane.showConfirmDialog(null, panel, "SONDEO DE PERCEPCIONES (PTU)", 
                                                       JOptionPane.OK_CANCEL_OPTION, 
                                                       JOptionPane.PLAIN_MESSAGE);
            if (opcion != JOptionPane.OK_OPTION) return false;

            confPTU = rbSi.isSelected();
            if (confPTU) {
                try {
                    PTUPagado = Double.parseDouble(ptuField.getText());
                    if (PTUPagado < 0) throw new Exception("Monto no puede ser negativo.");
                    return true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingrese un monto válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                PTUPagado = 0;
                return true;
            }
        }
    }
    
    // Creación de modulo Adrían Barrera Cruz 24/10/25 a las 13:10
    // Objetivo: Recopilar datos sobre trabajo en días no habituales: cuántos domingos y cuántos días de descanso obligatorio se laboraron.
    private boolean pedirDatosDomingosDescansos() {
        JRadioButton rbDomSi = new JRadioButton("Sí");
        JRadioButton rbDomNo = new JRadioButton("No");
        rbDomNo.setSelected(true);
        ButtonGroup bgDom = new ButtonGroup();
        bgDom.add(rbDomSi); bgDom.add(rbDomNo);
        JTextField domField = new JTextField(5);
        domField.setEnabled(false);
        
        JRadioButton rbDescSi = new JRadioButton("Sí");
        JRadioButton rbDescNo = new JRadioButton("No");
        rbDescNo.setSelected(true);
        ButtonGroup bgDesc = new ButtonGroup();
        bgDesc.add(rbDescSi); bgDesc.add(rbDescNo);
        JTextField descSem1Field = new JTextField(5);
        JTextField descSem2Field = new JTextField(5);
        descSem1Field.setEnabled(false);
        descSem2Field.setEnabled(false);

        rbDomSi.addActionListener(e -> domField.setEnabled(true));
        rbDomNo.addActionListener(e -> {
            domField.setEnabled(false);
            domField.setText("");
        });
        
        rbDescSi.addActionListener(e -> {
            descSem1Field.setEnabled(true);
            descSem2Field.setEnabled(true);
        });
        rbDescNo.addActionListener(e -> {
            descSem1Field.setEnabled(false);
            descSem2Field.setEnabled(false);
            descSem1Field.setText("");
            descSem2Field.setText("");
        });

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("¿Trabajó Domingo?"));
        JPanel radioDomPanel = new JPanel();
        radioDomPanel.add(rbDomSi); radioDomPanel.add(rbDomNo);
        panel.add(radioDomPanel);
        panel.add(new JLabel("Domingos trabajados:"));
        panel.add(domField);
        
        panel.add(new JSeparator());
        
        panel.add(new JLabel("¿Trabajó días no laborales?"));
        JPanel radioDescPanel = new JPanel();
        radioDescPanel.add(rbDescSi); radioDescPanel.add(rbDescNo);
        panel.add(radioDescPanel);
        panel.add(new JLabel("Días no laborales trabajados semana 1:"));
        panel.add(descSem1Field);
        panel.add(new JLabel("Días no laborales trabajados semana 2:"));
        panel.add(descSem2Field);

        while (true) {
            int opcion = JOptionPane.showConfirmDialog(null, panel, "SONDEO DE PERCEPCIONES (Descansos)", 
                                                       JOptionPane.OK_CANCEL_OPTION, 
                                                       JOptionPane.PLAIN_MESSAGE);
            if (opcion != JOptionPane.OK_OPTION) return false;

            try {
                confdom = rbDomSi.isSelected();
                if (confdom) {
                    dom = Integer.parseInt(domField.getText());
                    if (dom < 0) throw new Exception("Domingos no pueden ser negativos.");
                } else {
                    dom = 0;
                }
                
                confdesc = rbDescSi.isSelected();
                if (confdesc) {
                    descSem1 = Integer.parseInt(descSem1Field.getText());
                    descSem2 = Integer.parseInt(descSem2Field.getText());
                    if (descSem1 < 0 || descSem2 < 0) throw new Exception("Días no pueden ser negativos.");
                } else {
                    descSem1 = 0;
                    descSem2 = 0;
                }
                return true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Creación de modulo Adrían Barrera Cruz 24/10/25 a las 15:38
    // Objetivo: Preguntar si se laboraron horas extra y registrar la cantidad correspondiente a cada semana.
    private boolean pedirDatosHorasExtra() {
        JRadioButton rbSi = new JRadioButton("Sí");
        JRadioButton rbNo = new JRadioButton("No");
        rbNo.setSelected(true);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbSi); bg.add(rbNo);

        JTextField hrexSem1Field = new JTextField(5);
        JTextField hrexSem2Field = new JTextField(5);
        hrexSem1Field.setEnabled(false);
        hrexSem2Field.setEnabled(false);

        rbSi.addActionListener(e -> {
            hrexSem1Field.setEnabled(true);
            hrexSem2Field.setEnabled(true);
        });
        rbNo.addActionListener(e -> {
            hrexSem1Field.setEnabled(false);
            hrexSem2Field.setEnabled(false);
            hrexSem1Field.setText("");
            hrexSem2Field.setText("");
        });
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("¿Trabajó horas extra?"));
        JPanel radioPanel = new JPanel();
        radioPanel.add(rbSi); radioPanel.add(rbNo);
        panel.add(radioPanel);
        panel.add(new JLabel("Horas extra semana 1:"));
        panel.add(hrexSem1Field);
        panel.add(new JLabel("Horas extra semana 2:"));
        panel.add(hrexSem2Field);
        
        while (true) {
            int opcion = JOptionPane.showConfirmDialog(null, panel, "SONDEO DE PERCEPCIONES (Horas Extra)", 
                                                       JOptionPane.OK_CANCEL_OPTION, 
                                                       JOptionPane.PLAIN_MESSAGE);
            if (opcion != JOptionPane.OK_OPTION) return false;

            confhrex = rbSi.isSelected();
            if (confhrex) {
                try {
                    hrexSem1 = Integer.parseInt(hrexSem1Field.getText());
                    hrexSem2 = Integer.parseInt(hrexSem2Field.getText());
                    if (hrexSem1 < 0 || hrexSem2 < 0) throw new Exception("Horas no pueden ser negativas.");
                    return true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingrese números válidos para las horas.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                hrexSem1 = 0;
                hrexSem2 = 0;
                return true;
            }
        }
    }
    
    // Creación de modulo Adrían Barrera Cruz 24/10/25 a las 17:02
    // Objetivo: Preguntar si el empleado recibió algún bono extraordinario y, en caso afirmativo, registrar el monto.
    private boolean pedirDatosBono() {
        JRadioButton rbSi = new JRadioButton("Sí");
        JRadioButton rbNo = new JRadioButton("No");
        rbNo.setSelected(true);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbSi); bg.add(rbNo);

        JTextField bonoField = new JTextField(10);
        bonoField.setEnabled(false);

        rbSi.addActionListener(e -> bonoField.setEnabled(true));
        rbNo.addActionListener(e -> {
            bonoField.setEnabled(false);
            bonoField.setText("");
        });
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("¿Recibió un bono esta quincena?"));
        JPanel radioPanel = new JPanel();
        radioPanel.add(rbSi); radioPanel.add(rbNo);
        panel.add(radioPanel);
        panel.add(new JLabel("Ingrese el monto:"));
        panel.add(bonoField);
        
        while (true) {
            int opcion = JOptionPane.showConfirmDialog(null, panel, "SONDEO DE PERCEPCIONES (Bono)", 
                                                       JOptionPane.OK_CANCEL_OPTION, 
                                                       JOptionPane.PLAIN_MESSAGE);
            if (opcion != JOptionPane.OK_OPTION) return false;

            confBono = rbSi.isSelected();
            if (confBono) {
                try {
                    Bono = Double.parseDouble(bonoField.getText());
                    if (Bono < 0) throw new Exception("Monto no puede ser negativo.");
                    return true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingrese un monto válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                Bono = 0;
                return true;
            }
        }
    }

    // Creación de modulo Adrían Barrera Cruz 25/10/25 a las 10:25
    // Objetivo: Preguntar si se debe aplicar un descuento por préstamo y, en caso afirmativo, registrar el monto a deducir.
    private boolean pedirDatosPrestamo() {
        JRadioButton rbSi = new JRadioButton("Sí");
        JRadioButton rbNo = new JRadioButton("No");
        rbNo.setSelected(true);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbSi); bg.add(rbNo);

        JTextField prestamoField = new JTextField(10);
        prestamoField.setEnabled(false);

        rbSi.addActionListener(e -> prestamoField.setEnabled(true));
        rbNo.addActionListener(e -> {
            prestamoField.setEnabled(false);
            prestamoField.setText("");
        });
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("¿Pidió algún préstamo en la quincena?"));
        JPanel radioPanel = new JPanel();
        radioPanel.add(rbSi); radioPanel.add(rbNo);
        panel.add(radioPanel);
        panel.add(new JLabel("Ingrese el monto:"));
        panel.add(prestamoField);
        
        while (true) {
            int opcion = JOptionPane.showConfirmDialog(null, panel, "SONDEO DE DEDUCCIONES (Préstamo)", 
                                                       JOptionPane.OK_CANCEL_OPTION, 
                                                       JOptionPane.PLAIN_MESSAGE);
            if (opcion != JOptionPane.OK_OPTION) return false;

            confpres = rbSi.isSelected();
            if (confpres) {
                try {
                    Prestamo = Double.parseDouble(prestamoField.getText());
                    if (Prestamo < 0) throw new Exception("Monto no puede ser negativo.");
                    return true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: Ingrese un monto válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                Prestamo = 0;
                return true;
            }
        }
    }

    // Creación de modulo Adrían Barrera Cruz 25/10/25 a las 12:00
    // Objetivo: Ejecutar toda la lógica de negocio. Utiliza las variables globales (capturadas) para calcular todas las percepciones, deducciones (IMSS, ISR), totales y el salario neto final.
    public void realizarCalculos() {
        
        DiasTrabSem1 = 6 - FalSem1;
        DiasTrabSem2 = 6 - FalSem2;
        SalDia = salhr * 8;
        SalSem1 = (SalDia * DiasTrabSem1) + ((SalDia * DiasTrabSem1) / 6.0);
        SalSem2 = (SalDia * DiasTrabSem2) + ((SalDia * DiasTrabSem2) / 6.0);
        SalBasQuin = SalSem1 + SalSem2;
        
        if (confdesc) {
            SalAdDescSem1 = (SalDia * 2) * descSem1;
            SalAdDescSem2 = (SalDia * 2) * descSem2;
            
            TotSalDescSem1 = (SalDia * descSem1) + SalAdDescSem1;
            TotSalDescSem2 = (SalDia * descSem2) + SalAdDescSem2;
            
            SalDesc = TotSalDescSem1 + TotSalDescSem2;
        }
        
        if (confhrex) {
            if (hrexSem1 <= 9) {
                Salhrex2Sem1 = (hrexSem1 * salhr) * 2;
                Salhrex3Sem1 = 0;
                SalhrexSem1 = Salhrex2Sem1;
            } else {
                Salhrex2Sem1 = (9 * salhr) * 2;
                Salhrex3Sem1 = ((hrexSem1 - 9) * (salhr * 3));
                SalhrexSem1 = Salhrex2Sem1 + Salhrex3Sem1;
            }
            
            if (hrexSem2 <= 9) {
                Salhrex2Sem2 = (hrexSem2 * salhr) * 2;
                Salhrex3Sem2 = 0;
                SalhrexSem2 = Salhrex2Sem2;
            } else {
                Salhrex2Sem2 = (9 * salhr) * 2;
                Salhrex3Sem2 = ((hrexSem2 - 9) * (salhr * 3));
                SalhrexSem2 = Salhrex2Sem2 + Salhrex3Sem2;
            }
            
            Salhrex = SalhrexSem1 + SalhrexSem2;
        } else {
            Salhrex = 0;
            Salhrex3Sem1 = 0;
            Salhrex3Sem2 = 0;
        }

        if (confdom) {
            PrimDom = (SalDia * 0.25) * dom;
        } else {
            PrimDom = 0;
        }
        
        calcularDiasVacaciones(); 

        if (confAguinaldo) {
            calcularDiasAguinaldo();
            Aguin = (DiasTrabajados / 365.0) * (SalDia * 15);
        } else {
            Aguin = 0;
        }
        
        if (confvac) {
            PrimaVacacional = (SalDia * diasVacaciones) * 0.25;
        } else {
            PrimaVacacional = 0;
        }
        
        FactorIntegra = (365 + 15 + (diasVacaciones * 0.25)) / 365.0;
        SBC = SalDia * FactorIntegra;
        
        if (SBC > (3 * UMA)) {
            EnfeYMaterEsp = (SBC - (3 * UMA)) * 15 * 0.004;
        } else {
            EnfeYMaterEsp = 0;
        }
        
        EnfeYMaterDin = SBC * 15 * 0.0025;
        EnfeYMater = EnfeYMaterDin + EnfeYMaterEsp;
        
        InvalYVida = SBC * 15 * 0.00625;
        
        RetiroCV = SBC * 15 * 0.01125;
        
        CuotaIMSS = EnfeYMater + InvalYVida + RetiroCV;

        if (confhrex) {
            LimiteExencion = UMA * 5;
            ExencionPotencialHrexSem1 = Salhrex2Sem1 * 0.5;
            
            if (ExencionPotencialHrexSem1 > LimiteExencion) {
                BGSalhrex2Sem1 = Salhrex2Sem1 - LimiteExencion;
            } else {
                BGSalhrex2Sem1 = (Salhrex2Sem1 * 0.5);
            }
            
            ExencionPotencialHrexSem2 = Salhrex2Sem2 * 0.5;
            
            if (ExencionPotencialHrexSem2 > LimiteExencion) {
                BGSalhrex2Sem2 = Salhrex2Sem2 - LimiteExencion;
            } else {
                BGSalhrex2Sem2 = (Salhrex2Sem2 * 0.5);
            }
            
            BGSalhrex = BGSalhrex2Sem1 + BGSalhrex2Sem2;
        } else {
            BGSalhrex = 0;
        }

        if (confdesc) {
            LimiteExencion = UMA * 5;
            ExencionPotencialDescSem1 = SalAdDescSem1 * 0.5;
            
            if (ExencionPotencialDescSem1 > LimiteExencion) {
                BGSalDescSem1 = SalAdDescSem1 - LimiteExencion;
            } else {
                BGSalDescSem1 = SalAdDescSem1 * 0.5;
            }
            
            ExencionPotencialDescSem2 = SalAdDescSem2 * 0.5;
            
            if (ExencionPotencialDescSem2 > LimiteExencion) {
                BGSalDescSem2 = SalAdDescSem2 - LimiteExencion;
            } else {
                BGSalDescSem2 = SalAdDescSem2 * 0.5;
            }
            
            BGSalDesc = BGSalDescSem1 + BGSalDescSem2;
        } else {
            BGSalDesc = 0;
        }

        if (confdom) {
            if (PrimDom <= (dom * UMA)) {
                BGPrimDom = 0;
            } else {
                BGPrimDom = (PrimDom - (dom * UMA));
            }
        } else {
            BGPrimDom = 0;
        }
        
        if (confAguinaldo) {
            LimiteExencionAguin = 30 * UMA;
            if (Aguin > LimiteExencionAguin) {
                BGAguin = Aguin - LimiteExencionAguin;
            } else {
                BGAguin = 0;
            }
        } else {
            BGAguin = 0;
        }
        
        if (confPTU) {
            LimiteExencionPTU = UMA * 15;
            if (PTUPagado > LimiteExencionPTU) {
                BGPTU = PTUPagado - LimiteExencionPTU;
            } else {
                BGPTU = 0;
            }
        } else {
            BGPTU = 0;
        }
        
        if (confvac) {
            LimiteExencionPV = UMA * 15;
            if (PrimaVacacional > LimiteExencionPV) {
                BGPrimaVacacional = PrimaVacacional - LimiteExencionPV;
            } else {
                BGPrimaVacacional = 0;
            }
        } else {
            BGPrimaVacacional = 0;
        }
        
        TotalSalario = SalBasQuin + SalDesc + Salhrex + PrimDom + Aguin + PrimaVacacional + PTUPagado + Bono;
        TotalGravable = SalBasQuin + BGSalhrex + Salhrex3Sem1 + Salhrex3Sem2 + BGSalDesc + BGPrimDom + BGAguin + BGPrimaVacacional + BGPTU + Bono;

        if (TotalGravable > 0 && TotalGravable <= 368.10) {
            LimiteInferior = 0.01;
            CuotaFija = 0.00;
            TasaExcedente = 0.0192;
        } else if (TotalGravable <= 3124.35) {
            LimiteInferior = 368.11;
            CuotaFija = 7.05;
            TasaExcedente = 0.0640;
        } else if (TotalGravable <= 5490.75) {
            LimiteInferior = 3124.36;
            CuotaFija = 183.45;
            TasaExcedente = 0.1088;
        } else if (TotalGravable <= 6382.80) {
            LimiteInferior = 5490.76;
            CuotaFija = 441.00;
            TasaExcedente = 0.1600;
        } else if (TotalGravable <= 7641.90) {
            LimiteInferior = 6382.81;
            CuotaFija = 583.65;
            TasaExcedente = 0.1792;
        } else if (TotalGravable <= 15412.80) {
            LimiteInferior = 7641.91;
            CuotaFija = 809.25;
            TasaExcedente = 0.2136;
        } else if (TotalGravable <= 24292.65) {
            LimiteInferior = 15412.81;
            CuotaFija = 2469.15;
            TasaExcedente = 0.2352;
        } else if (TotalGravable <= 46378.50) {
            LimiteInferior = 24292.66;
            CuotaFija = 4557.75;
            TasaExcedente = 0.3000;
        } else if (TotalGravable <= 61838.10) {
            LimiteInferior = 46378.51;
            CuotaFija = 11183.40;
            TasaExcedente = 0.3200;
        } else if (TotalGravable <= 185514.30) {
            LimiteInferior = 61838.11;
            CuotaFija = 16130.55;
            TasaExcedente = 0.3400;
        } else {
            LimiteInferior = 185514.31;
            CuotaFija = 58180.35;
            TasaExcedente = 0.3500;
        }
        
        Excedente = TotalGravable - LimiteInferior;
        ImpuestoMarginal = Excedente * TasaExcedente;
        ISR = ImpuestoMarginal + CuotaFija;
        
        TotalDeducciones = ISR + Prestamo + CuotaIMSS;
        SalaNeto = TotalSalario - TotalDeducciones;
    }

    // Creación de modulo Adrían Barrera Cruz 25/10/25 a las 15:18
    // Objetivo: Mostrar al usuario una serie de ventanas emergentes que explican paso a paso cómo se calcularon los conceptos clave (Salario, SBC, IMSS, ISR).
    public void mostrarDetalleCalculos() {
        String msgBase = String.format(
            "--- PERCEPCIONES ORDINARIAS ---\n\n" +
            "Salario día (salario hr * 8): %.2f * 8 = %.2f\n\n" +
            "Semana 1 (%d días trabajados, %d faltas):\n" +
            "(%.2f * %d) + ((%.2f * %d) / 6) = %s\n\n" +
            "Semana 2 (%d días trabajados, %d faltas):\n" +
            "(%.2f * %d) + ((%.2f * %d) / 6) = %s\n\n" +
            "Salario base quincenal (Sem1 + Sem2):\n" +
            "%s + %s = %s",
            salhr, SalDia,
            DiasTrabSem1, FalSem1,
            SalDia, DiasTrabSem1, SalDia, DiasTrabSem1, df.format(SalSem1),
            DiasTrabSem2, FalSem2,
            SalDia, DiasTrabSem2, SalDia, DiasTrabSem2, df.format(SalSem2),
            df.format(SalSem1), df.format(SalSem2), df.format(SalBasQuin)
        );
        mostrarMensajeDetalle(msgBase, "Cálculo Salario Base");

        if (confhrex) {
            String msgHrex = String.format(
                "--- PERCEPCIONES EXTRAORDINARIAS - HORAS EXTRA ---\n\n" +
                "Semana 1 (%d horas extra):\n" +
                "Horas dobles (límite 9): %.2f\n" +
                "Horas triples (excedente): %.2f\n" +
                "Total Semana 1: %s\n\n" +
                "Semana 2 (%d horas extra):\n" +
                "Horas dobles (límite 9): %.2f\n" +
                "Horas triples (excedente): %.2f\n" +
                "Total Semana 2: %s\n\n" +
                "Total hrs. extra quincena (Sem1 + Sem2):\n" +
                "%s + %s = %s",
                hrexSem1,
                Salhrex2Sem1,
                Salhrex3Sem1,
                df.format(SalhrexSem1),
                hrexSem2,
                Salhrex2Sem2,
                Salhrex3Sem2,
                df.format(SalhrexSem2),
                df.format(SalhrexSem1), df.format(SalhrexSem2), df.format(Salhrex)
            );
            mostrarMensajeDetalle(msgHrex, "Cálculo Horas Extra");
        }
        
        if (confdesc) {
             String msgDesc = String.format(
                "--- PERCEPCIONES EXTRAORDINARIAS - DÍAS DE DESCANSO ---\n\n" +
                "Semana 1 (%d días descanso trabajados):\n" +
                "Salario Adicional (SalDia * 2) * días: (%.2f * 2) * %d = %.2f\n" +
                "Total (Salario Adicional + Salario Normal): %.2f\n\n" +
                "Semana 2 (%d días descanso trabajados):\n" +
                "Salario Adicional (SalDia * 2) * días: (%.2f * 2) * %d = %.2f\n" +
                "Total (Salario Adicional + Salario Normal): %.2f\n\n" +
                "Total días de descanso (Sem1 + Sem2):\n" +
                "%s + %s = %s",
                descSem1,
                SalDia, descSem1, SalAdDescSem1,
                TotSalDescSem1,
                descSem2,
                SalDia, descSem2, SalAdDescSem2,
                TotSalDescSem2,
                df.format(TotSalDescSem1), df.format(TotSalDescSem2), df.format(SalDesc)
            );
            mostrarMensajeDetalle(msgDesc, "Cálculo Días de Descanso");
        }
        
        if (confdom) {
            String msgDom = String.format(
                "--- PERCEPCIONES EXTRAORDINARIAS - PRIMA DOMINICAL ---\n\n" +
                "Domingos trabajados: %d\n" +
                "(Salario diario * 0.25) * días: (%.2f * 0.25) * %d = %s",
                dom,
                SalDia, dom, df.format(PrimDom)
            );
            mostrarMensajeDetalle(msgDom, "Cálculo Prima Dominical");
        }
        
        if (confAguinaldo) {
             String msgAguin = String.format(
                "--- PERCEPCIONES EXTRAORDINARIAS - AGUINALDO ---\n\n" +
                "Días trabajados en el año (proporcional): %d\n" +
                "(DiasTrabajados / 365) * (Salario Diario * 15):\n" +
                "(%d / 365.0) * (%.2f * 15) = %s",
                DiasTrabajados,
                DiasTrabajados, SalDia, df.format(Aguin)
            );
            mostrarMensajeDetalle(msgAguin, "Cálculo Aguinaldo");
        }

        if (confvac) {
            String msgVac = String.format(
                "--- PERCEPCIONES EXTRAORDINARIAS - PRIMA VACACIONAL ---\n\n" +
                "Días de vacaciones (antigüedad %d años): %d días\n" +
                "(Salario diario * Días de vacaciones) * 0.25:\n" +
                "(%.2f * %d) * 0.25 = %s",
                aniosServicio, diasVacaciones,
                SalDia, diasVacaciones, df.format(PrimaVacacional)
            );
            mostrarMensajeDetalle(msgVac, "Cálculo Prima Vacacional");
        }
        
        String msgSBC = String.format(
            "--- DEDUCCIONES - CÁLCULO SBC ---\n\n" +
            "Factor integración:\n" +
            "(365 Días + 15 Aguinaldo + ( %d Vacaciones * 0.25 Prima)) / 365\n" +
            "(365 + 15 + %.2f) / 365 = %.4f\n\n" +
            "SBC (Salario Diario * Factor integración):\n" +
            "%.2f * %.4f = %s",
            diasVacaciones,
            (diasVacaciones * 0.25), FactorIntegra,
            SalDia, FactorIntegra, df.format(SBC)
        );
        mostrarMensajeDetalle(msgSBC, "Cálculo SBC");
        
        String msgIMSS = String.format(
            "--- DEDUCCIONES - CÁLCULO IMSS (Quincenal) ---\n\n" +
            "Enfermedades y Maternidad (Especie):\n" +
            "((SBC - (3 * UMA)) * 15 * 0.004) = %.2f\n" +
            "Enfermedades y Maternidad (Dinero):\n" +
            "(SBC * 15 * 0.0025) = %.2f\n\n" +
            "Invalidez y Vida:\n" +
            "(SBC * 15 * 0.00625) = %.2f\n\n" +
            "Cesantía en Edad Avanzada y Vejez:\n" +
            "(SBC * 15 * 0.01125) = %.2f\n\n" +
            "Total IMSS: %s",
            EnfeYMaterEsp,
            EnfeYMaterDin,
            InvalYVida,
            RetiroCV,
            df.format(CuotaIMSS)
        );
        mostrarMensajeDetalle(msgIMSS, "Cálculo IMSS");
        
        double exSalhrex = Salhrex - (BGSalhrex + Salhrex3Sem1 + Salhrex3Sem2);
        double exSalDesc = (SalAdDescSem1 + SalAdDescSem2) - BGSalDesc; 
        double exPrimDom = PrimDom - BGPrimDom;
        double exAguin = Aguin - BGAguin;
        double exPTU = PTUPagado - BGPTU;
        double exPV = PrimaVacacional - BGPrimaVacacional;
        
        String msgGrav = String.format(
            "--- DEDUCCIONES - BASE GRAVABLE ISR ---\n\n" +
            "Concepto\t\tExento\t\tGravado\n" +
            "----------------------------------------------------------------------------------\n" +
            "Salario Base\t\t$ 0.00\t\t$ %s\n" +
            "Hrs. Extra (2x y 3x)\t$ %s\t$ %s\n" +
            "Días Descanso (Solo pago adicional)\t$ %s\t$ %s\n" +
            "Prima Dominical\t\t$ %s\t$ %s\n" +
            "Prima Vacacional\t\t$ %s\t$ %s\n" +
            "Aguinaldo\t\t$ %s\t$ %s\n" +
            "PTU\t\t\t$ %s\t$ %s\n" +
            "Bono\t\t\t$ 0.00\t\t$ %s\n" +
            "----------------------------------------------------------------------------------\n" +
            "Total Gravable: %s",
            df.format(SalBasQuin),
            df.format(exSalhrex), df.format(BGSalhrex + Salhrex3Sem1 + Salhrex3Sem2),
            df.format(exSalDesc), df.format(BGSalDesc),
            df.format(exPrimDom), df.format(BGPrimDom),
            df.format(exPV), df.format(BGPrimaVacacional),
            df.format(exAguin), df.format(BGAguin),
            df.format(exPTU), df.format(BGPTU),
            df.format(Bono),
            df.format(TotalGravable)
        );
        mostrarMensajeDetalle(msgGrav, "Cálculo Base Gravable");
        
        String msgISR = String.format(
            "--- DEDUCCIONES - CÁLCULO ISR ---\n\n" +
            "Base Gravable: %s\n" +
            "Límite Inferior: %s\n" +
            "Excedente (Base Gravable - Límite Inferior):\n" +
            "%.2f - %.2f = %.2f\n\n" +
            "Tasa sobre Excedente: %.2f%%\n" +
            "Impuesto Marginal (Excedente * Tasa):\n" +
            "%.2f * %.4f = %.2f\n\n" +
            "Cuota Fija: %s\n" +
            "ISR (Impuesto Marginal + Cuota Fija):\n" +
            "%.2f + %.2f = %s",
            df.format(TotalGravable),
            df.format(LimiteInferior),
            TotalGravable, LimiteInferior, Excedente,
            TasaExcedente * 100,
            Excedente, TasaExcedente, ImpuestoMarginal,
            df.format(CuotaFija),
            ImpuestoMarginal, CuotaFija, df.format(ISR)
        );
        mostrarMensajeDetalle(msgISR, "Cálculo ISR");
    }

    // Creación de modulo Adrían Barrera Cruz 25/10/25 a las 17:30
    // Objetivo: Mostrar el recibo de nómina final con el resumen de percepciones, deducciones y el líquido a pagar. Ofrece opciones para "descargar" (ver detalle), calcular una nueva nómina o salir.
    public boolean mostrarReciboFinal() {
        
        String recibo = String.format(
            "DESARROLLADORES DE SOFTWARE CODE & GO S.A. DE C.V.\n" +
            "--------------------------------------------------------------------------\n" +
            "NÓMINA\n\n" +
            "NOMBRE COMPLETO: \t%s\n" +
            "RFC: \t\t%s\n" +
            "TELÉFONO: \t%s\n" +
            "PERIODO: \t%d / %s\n" +
            "====================================================\n" +
            "PERCEPCIONES\t\tIMPORTE\n" +
            "--------------------------------------------------------------------------\n" +
            "SUELDO BASE\t\t$ %s\n" +
            "HORAS EXTRA\t\t$ %s\n" +
            "DIAS DE DESCANSO TRABAJADO\t$ %s\n" +
            "AGUINALDO\t\t$ %s\n" +
            "PRIMA VACACIONAL\t\t$ %s\n" +
            "PRIMA DOMINICAL\t\t$ %s\n" +
            "PTU\t\t\t$ %s\n" +
            "BONO\t\t\t$ %s\n" +
            "\n" +
            "====================================================\n" +
            "DEDUCCIONES\t\tIMPORTE\n" +
            "--------------------------------------------------------------------------\n" +
            "ISR\t\t\t$ %s\n" +
            "IMSS\t\t\t$ %s\n" +
            "PRESTAMO\t\t$ %s\n" +
            "\n" +
            "====================================================\n" +
            "TOTAL PERCEPCIONES:\t$ %s\n" +
            "TOTAL DEDUCCIONES:\t$ %s\n" +
            "LÍQUIDO:\t\t$ %s\n" +
            "====================================================\n",
            nom, rfc, tel, dia, mes,
            df.format(SalBasQuin),
            df.format(Salhrex),
            df.format(SalDesc),
            df.format(Aguin),
            df.format(PrimaVacacional),
            df.format(PrimDom),
            df.format(PTUPagado),
            df.format(Bono),
            df.format(ISR),
            df.format(CuotaIMSS),
            df.format(Prestamo),
            df.format(TotalSalario),
            df.format(TotalDeducciones),
            df.format(SalaNeto)
        );

        Object[] options = {"DESCARGAR RECIBO DE NÓMINA", "NUEVA NÓMINA", "Salir"};
        int n = JOptionPane.showOptionDialog(null,
            "Cálculo finalizado.",
            "Resultados",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[0]);

        if (n == 0) {
            JTextArea textArea = new JTextArea(30, 60);
            textArea.setText(recibo);
            textArea.setEditable(false);
            textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
            JScrollPane scrollPane = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(null, scrollPane, "Recibo de Nómina", JOptionPane.PLAIN_MESSAGE);
            return mostrarReciboFinal();
        } else if (n == 1) {
            return true;
        } else {
            return false;
        }
    }

    // Creación de modulo Adrían Barrera Cruz 26/10/25 a las 11:09
    // Objetivo: Determinar la cantidad de días de vacaciones que le corresponden al empleado según la tabla de antigüedad de la LFT.
    private void calcularDiasVacaciones() {
        if (aniosServicio <= 0) {
            diasVacaciones = 0;
        } else if (aniosServicio == 1) {
            diasVacaciones = 12;
        } else if (aniosServicio == 2) {
            diasVacaciones = 14;
        } else if (aniosServicio == 3) {
            diasVacaciones = 16;
        } else if (aniosServicio == 4) {
            diasVacaciones = 18;
        } else if (aniosServicio == 5) {
            diasVacaciones = 20;
        } else if (aniosServicio >= 6 && aniosServicio <= 10) {
            diasVacaciones = 22;
        } else if (aniosServicio >= 11 && aniosServicio <= 15) {
            diasVacaciones = 24;
        } else if (aniosServicio >= 16 && aniosServicio <= 20) {
            diasVacaciones = 26;
        } else if (aniosServicio >= 21 && aniosServicio <= 25) {
            diasVacaciones = 28;
        } else if (aniosServicio >= 26 && aniosServicio <= 30) {
            diasVacaciones = 30;
        } else {
            diasVacaciones = 32;
        }
    }
    
    // Creación de modulo Adrían Barrera Cruz 26/10/25 a las 12:41
    // Objetivo: Calcular los días trabajados proporcionales en el año para el pago del aguinaldo, considerando la fecha de ingreso y las faltas anuales.
    private void calcularDiasAguinaldo() {
        if (Confingreso) {
            switch (mesingr) {
                case 1: diasAcumulados = 0; break;
                case 2: diasAcumulados = 31; break;
                case 3: diasAcumulados = 59; break;
                case 4: diasAcumulados = 90; break;
                case 5: diasAcumulados = 120; break;
                case 6: diasAcumulados = 151; break;
                case 7: diasAcumulados = 181; break;
                case 8: diasAcumulados = 212; break;
                case 9: diasAcumulados = 243; break;
                case 10: diasAcumulados = 273; break;
                case 11: diasAcumulados = 304; break;
                case 12: diasAcumulados = 334; break;
                default: diasAcumulados = 0;
            }
            diaInicialDelAnio = diasAcumulados + diaingr;
        } else {
            diaInicialDelAnio = 1;
        }
        DiasTranscurridos = 365 - diaInicialDelAnio + 1;
        DiasTrabajados = DiasTranscurridos - FalAnio;
    }

    // Creación de modulo Adrían Barrera Cruz 26/10/25 a las 14:05
    // Objetivo: Método de utilidad para mostrar un mensaje (posiblemente largo) dentro de un JTextArea con barras de desplazamiento.
    private void mostrarMensajeDetalle(String mensaje, String titulo) {
        JTextArea textArea = new JTextArea(20, 50);
        textArea.setText(mensaje);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}