package semm6.dip;

import java.util.List;

public abstract class Output {

    public void output(List<ReportItem> items) {
    }

    public static class ReportItem {

        private String description;
        private float amount;

        public ReportItem(String description, float amount) {
            this.description = description;
            this.amount = amount;
        }

        public float getAmount() {
            return amount;
        }

        public String getDescription() {
            return description;
        }
    }
}