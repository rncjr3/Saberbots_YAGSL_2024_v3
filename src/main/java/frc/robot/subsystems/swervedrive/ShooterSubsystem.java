package frc.robot.subsystems.swervedrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.Timer;


public class ShooterSubsystem extends SubsystemBase {
    private CANSparkMax TopShooterMotor = new CANSparkMax(15,MotorType.kBrushless);
    private CANSparkMax BottomShooterMotor = new CANSparkMax(14,MotorType.kBrushless);
    Timer timer = new Timer();

    public ShooterSubsystem(){
        TopShooterMotor.setSmartCurrentLimit(130);
        BottomShooterMotor.setSmartCurrentLimit(130); 
    }

    public void shootTop(){
        TopShooterMotor.set(1);
    }

    public void shootBottom(){
        BottomShooterMotor.set(-1);
    }

    public void shootSlow(){
        TopShooterMotor.set(0.15);
        BottomShooterMotor.set(-0.15);
    }

    public void intake(){
        
        TopShooterMotor.set(-0.1);
        BottomShooterMotor.set(0.1);
    }

    public void stopShooter(){
        TopShooterMotor.set(0);
        BottomShooterMotor.set(0);
    }

    public void shootSpeaker(){
        timer.reset();
        timer.start();
        while(timer.get()<2){
            TopShooterMotor.setVoltage(16);
            if(timer.get()>1){
                BottomShooterMotor.setVoltage(-16);
            }
        }
        TopShooterMotor.set(0);
        BottomShooterMotor.set(0);
    }

    public void shootAMP(){
        System.out.println("Shooting amp");
        System.out.println(TopShooterMotor.get());
        timer.reset();
        timer.start();
        while(timer.get()<1.5){
            TopShooterMotor.set(0.15);
            BottomShooterMotor.set(-0.15);
        }
        System.out.println(TopShooterMotor.get());
        TopShooterMotor.set(0);
        BottomShooterMotor.set(0);
    }
}
