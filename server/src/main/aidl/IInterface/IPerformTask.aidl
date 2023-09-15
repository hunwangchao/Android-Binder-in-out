// IPerformTask.aidl
package IInterface;

import IInterface.VerificationData;
import IInterface.Feedback;
// Declare any non-default types here with import statements

interface IPerformTask {

      void performVerify(inout VerificationData data, out Feedback feedback);
}